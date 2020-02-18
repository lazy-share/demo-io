package com.lazy.demo.io.server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/16.
 */
public class AIOTimeServerHandler implements Runnable {

    private CountDownLatch latch;
    private AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public AIOTimeServerHandler(int port) {

        try {
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        latch = new CountDownLatch(1);

        try {
            doAccept();
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doAccept() {
        asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
    }

    public static class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AIOTimeServerHandler> {

        public AcceptCompletionHandler() {
        }

        @Override
        public void completed(AsynchronousSocketChannel result, AIOTimeServerHandler attachment) {

            attachment.asynchronousServerSocketChannel.accept(attachment, this);

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            result.read(buffer, buffer, new ReadCompletionHandler(result));
        }

        @Override
        public void failed(Throwable exc, AIOTimeServerHandler attachment) {

            exc.printStackTrace();
            attachment.latch.countDown();
        }

        public static class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

            private AsynchronousSocketChannel channel;

            public ReadCompletionHandler(AsynchronousSocketChannel channel) {
                this.channel = channel;
            }

            @Override
            public void completed(Integer result, ByteBuffer attachment) {

                attachment.flip();
                byte[] body = new byte[attachment.remaining()];
                attachment.get(body);

                try {
                    String req = new String(body, "UTF-8");
                    System.out.println("The time server receive order: " + req);
                    String currentTime = "get time".equalsIgnoreCase(req) ? new Date(
                            System.currentTimeMillis()
                    ).toString() : "param error";

                    doWrite(currentTime);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            private void doWrite(String currentTime) {

                if (currentTime != null && currentTime.trim().length() > 0) {
                    byte[] bytes = currentTime.getBytes();
                    ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
                    writeBuffer.put(bytes);

                    writeBuffer.flip();

                    channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            if (writeBuffer.hasRemaining()) {
                                channel.write(writeBuffer, writeBuffer, this);
                            }
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {

                            try {
                                channel.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
