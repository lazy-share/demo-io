package com.lazy.demo.io.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/18.
 */
public class NettyTimeServerHandler extends ChannelInboundHandlerAdapter {


    public NettyTimeServerHandler() {
        super();
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");

        System.out.println("The time server receive order: " + body);

        String currentTime = "get time".equalsIgnoreCase(body) ?
                new Date(System.currentTimeMillis()).toString() : "param error";

        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
