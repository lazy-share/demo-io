package com.lazy.demo.io.server;

import com.lazy.demo.io.pojo.RpcReqProto;
import com.lazy.demo.io.pojo.RpcRespProto;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/19.
 */
public class NettyProtobufServer {

    public static void main(String[] args) throws InterruptedException {
        // Configure the server.
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        final NettyProtobufServerHandler serverHandler = new NettyProtobufServerHandler();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();

//                            p.addLast(new LoggingHandler(LogLevel.ERROR));

                            //消息长度（解决TCP粘包、半包） + Protobuf（字节编解码） 组合
                            p.addLast(new ProtobufVarint32FrameDecoder());
                            p.addLast("ProtobufDecoder2", new ProtobufDecoder(RpcReqProto.RpcReq.getDefaultInstance()));
                            p.addLast(new ProtobufVarint32LengthFieldPrepender());
                            p.addLast(new ProtobufEncoder());
                            p.addLast(serverHandler);
                        }
                    });

            // Start the server.
            ChannelFuture f = b.bind(8088).sync();

            // Wait until the server socket is closed.
            f.channel().closeFuture().sync();
        } finally {
            // Shut down all event loops to terminate all threads.
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
