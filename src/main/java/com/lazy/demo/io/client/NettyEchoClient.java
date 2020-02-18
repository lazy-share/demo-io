package com.lazy.demo.io.client;

import com.lazy.demo.io.codec.MessagePackDecoder;
import com.lazy.demo.io.codec.MessagePackEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
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
public class NettyEchoClient {


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

//                            p.addLast(new LoggingHandler(LogLevel.ERROR));
                            p.addLast("LengthFieldBasedFrameDecoder", new LengthFieldBasedFrameDecoder(65535, 0, 2, 0, 2));
                            p.addLast("messagePack decoder", new MessagePackDecoder());
                            p.addLast("LengthFieldPrepender", new LengthFieldPrepender(2));
                            p.addLast("messagePack encoder", new MessagePackEncoder());
                            p.addLast(new NettyEchoClientHandler());
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

