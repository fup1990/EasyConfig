package com.gome.fup.easyconfig.broker;

import com.gome.fup.easyconfig.common.Request;
import com.gome.fup.easyconfig.handler.ConfigHandler;
import com.gome.fup.easyconfig.handler.DecoderHandler;
import com.gome.fup.easyconfig.handler.EncoderHandler;
import com.gome.fup.easyconfig.service.ConfigService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by fupeng-ds on 2017/7/12.
 */
public class ConfigBroker implements Runnable, InitializingBean{

    private final Logger logger = Logger.getLogger(this.getClass());

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    private String host;

    private int port;

    @Autowired
    private ConfigService configService;

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("ConfigBroker is starting");
        executorService.submit(this);
    }

    @Override
    public void run() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap
                    .group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel)
                                throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new DecoderHandler(Request.class))
                                    .addLast(new EncoderHandler())
                                    .addLast(new ConfigHandler(configService));
                        }
                    }).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture future = bootstrap.bind(host, port).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            executorService.shutdown();
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
