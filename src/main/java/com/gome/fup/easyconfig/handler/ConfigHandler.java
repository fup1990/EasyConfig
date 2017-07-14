package com.gome.fup.easyconfig.handler;

import com.gome.fup.easyconfig.common.Request;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Map;

/**
 * Created by fupeng-ds on 2017/7/14.
 */
public class ConfigHandler extends SimpleChannelInboundHandler<Request> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Request request) throws Exception {

    }
}
