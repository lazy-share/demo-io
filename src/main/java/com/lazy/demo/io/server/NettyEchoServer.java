package com.lazy.demo.io.server;

import com.lazy.demo.io.codec.MessagePackDecoder;
import com.lazy.demo.io.codec.MessagePackEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/18.
 */
public class NettyEchoServer {


    public static void main(String[] args) throws InterruptedException {
        // Configure the server.
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        final NettyEchoServerHandler serverHandler = new NettyEchoServerHandler();
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
                            p.addLast("LengthFieldBasedFrameDecoder", new LengthFieldBasedFrameDecoder(65535, 0, 2, 0, 2));
                            p.addLast("messagePack decoder", new MessagePackDecoder());
                            p.addLast("LengthFieldPrepender", new LengthFieldPrepender(2));
                            p.addLast("messagePack encoder", new MessagePackEncoder());
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
