package com.lazy.demo.io.server;

import com.lazy.demo.io.pojo.RpcReqProto;
import com.lazy.demo.io.pojo.RpcRespProto;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/19.
 */
@ChannelHandler.Sharable
public class NettyProtobufServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        RpcReqProto.RpcReq req = (RpcReqProto.RpcReq) msg;

        System.out.println("The protobuf server receive msg: " + req.toString());

        RpcRespProto.RpcResp rpcResp = RpcRespProto.RpcResp.newBuilder()

                .setCode("200")
                .setMsg("success")
                .setBody(req.getBody())

                .build();

        ctx.writeAndFlush(rpcResp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
