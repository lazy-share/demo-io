package com.lazy.demo.io.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/18.
 */
public class NettyTimeClientHandler extends ChannelInboundHandlerAdapter {


    private final ByteBuf firstMessage;

    public NettyTimeClientHandler() {


        byte[] bytes = new byte[256];
        firstMessage = Unpooled.buffer(bytes.length);

        //固定启动后往服务端写20次数据包，每隔数据包大小固定为256个字节长度
        for (int i = 0; i < 20; i++) {
            firstMessage.writeBytes(bytes);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);

        String body = new String(bytes, "UTF-8");

        System.out.println("Now is : " + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
