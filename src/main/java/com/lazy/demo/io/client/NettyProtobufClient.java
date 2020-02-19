package com.lazy.demo.io.client;

import com.lazy.demo.io.pojo.RpcReqProto;
import com.lazy.demo.io.pojo.RpcRespProto;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/18.
 */
public class NettyProtobufClient {


    public static void main(String[] args) throws InterruptedException {

        // Configure the client.
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();

//                           //消息长度（解决TCP粘包、半包） + Protobuf（字节编解码） 组合
                            p.addLast(new ProtobufVarint32FrameDecoder());
                            p.addLast("ProtobufDecoder1", new ProtobufDecoder(RpcRespProto.RpcResp.getDefaultInstance()));
//                            p.addLast("ProtobufDecoder2", new ProtobufDecoder(RpcReqProto.RpcReq.getDefaultInstance()));
                            p.addLast(new ProtobufVarint32LengthFieldPrepender());
                            p.addLast(new ProtobufEncoder());
                            p.addLast(new NettyProtobufClientHandler());
                        }
                    });

            // Start the client.
            ChannelFuture f = b.connect("localhost", 8088).sync();

            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } finally {
            // Shut down the event loop to terminate all threads.
            group.shutdownGracefully();
        }
    }

}

