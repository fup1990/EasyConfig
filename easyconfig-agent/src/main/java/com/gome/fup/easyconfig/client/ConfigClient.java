package com.gome.fup.easyconfig.client;

import com.gome.fup.easyconfig.common.Config;
import com.gome.fup.easyconfig.common.Metadata;
import com.gome.fup.easyconfig.common.Request;
import com.gome.fup.easyconfig.common.Response;
import com.gome.fup.easyconfig.handler.DecoderHandler;
import com.gome.fup.easyconfig.handler.EncoderHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.List;
import java.util.Properties;

/**
 * Created by fupeng-ds on 2017/7/21.
 */
public class ConfigClient extends SimpleChannelInboundHandler<Response> {

    private final Object obj = new Object();

    protected String host;

    protected int port;

    private Response response;

    private Response send(Request request) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline()
                                    .addLast(new EncoderHandler())
                                    .addLast(new DecoderHandler(Response.class))
                                    .addLast(ConfigClient.this);
                        }
                    }).option(ChannelOption.SO_KEEPALIVE, true);
            // 链接服务器
            ChannelFuture future = bootstrap.connect(host, port).sync();
            // 将request对象写入outbundle处理后发出
            future.channel().writeAndFlush(request).sync();

            synchronized (obj) {
            // 用线程等待的方式决定是否关闭连接
            // 其意义是：先在此阻塞，等待获取到服务端的返回后，被唤醒，从而关闭网络连接
                obj.wait();
            }

            if (response != null) {
            // 服务器同步连接断开时,这句代码才会往下执行
                future.channel().closeFuture().sync();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
        return response;
    }

    protected Properties loadConfig(Long projectId, String groupName, String key) {
        Request request = getRequest(projectId, groupName, key);
        Response response = send(request);
        return format(response);
    }

    private Properties format(Response response) {
        List<Config> configs = response.getConfigs();
        return getProperties(configs);
    }

    private Properties getProperties(List<Config> configs) {
        Properties properties = new Properties();
        for (Config config : configs) {
            List<Metadata> metadatas = config.getMetadataList();
            for (Metadata data : metadatas) {
                properties.put(data.getKey(), data.getValue());
            }
        }
        return properties;
    }


    private Request getRequest(Long projectId, String groupName, String key) {
        Request request = new Request();
        request.setProjectId(projectId);
        request.setGroupName(groupName);
        request.setKey(key);
        return request;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Response response) throws Exception {
        this.response = response;
        synchronized (obj) {
            obj.notifyAll();
        }
    }
}
