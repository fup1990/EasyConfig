package com.gome.fup.easyconfig.client;

import com.gome.fup.easyconfig.common.Request;
import com.gome.fup.easyconfig.common.Response;
import com.gome.fup.easyconfig.handler.DecoderHandler;
import com.gome.fup.easyconfig.handler.EncoderHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by fupeng-ds on 2017/7/21.
 */
public class ConfigClient {

    private String host;

    private int port;

    public void send(Request request) {
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
                                    .addLast(new DecoderHandler(Response.class));
                        }
                    }).option(ChannelOption.SO_KEEPALIVE, true);
            // 链接服务器
            ChannelFuture future = bootstrap.connect(host, port).sync();
            // 将request对象写入outbundle处理后发出
            future.channel().writeAndFlush(request).sync();

            // synchronized (obj) {
            // 用线程等待的方式决定是否关闭连接
            // 其意义是：先在此阻塞，等待获取到服务端的返回后，被唤醒，从而关闭网络连接
            // obj.wait();
            // }

            // if (response != null) {
            // 服务器同步连接断开时,这句代码才会往下执行
            future.channel().closeFuture().sync();
            // }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
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
}
