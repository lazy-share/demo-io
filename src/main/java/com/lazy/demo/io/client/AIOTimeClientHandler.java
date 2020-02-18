package com.lazy.demo.io.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/16.
 */
public class AIOTimeClientHandler implements Runnable
        , CompletionHandler<Void, AIOTimeClientHandler> {

    private String host;
    private int port;
    private AsynchronousSocketChannel client;
    private CountDownLatch latch;

    public AIOTimeClientHandler(String host, int port) {
        this.host = host;
        this.port = port;

        try {
            client = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        latch = new CountDownLatch(1);

        client.connect(new InetSocketAddress(host, port), this, this);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void completed(Void result, AIOTimeClientHandler attachment) {

        byte[] req = "get time".getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();

        client.write(writeBuffer, writeBuffer,
                new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer buffer) {
                        if (buffer.hasRemaining()) {
                            client.write(buffer, buffer, this);
                        } else {
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                            client.read(readBuffer, readBuffer,
                                    new CompletionHandler<Integer, ByteBuffer>() {
                                        @Override
                                        public void completed(Integer result, ByteBuffer buffer) {
                                            buffer.flip();
                                            byte[] bytes = new byte[buffer.remaining()];
                                            buffer.get(bytes);

                                            String body;

                                            try {
                                                body = new String(bytes, "UTF-8");
                                                System.out.println("Now is : " + body);

                                                latch.countDown();
                                            } catch (UnsupportedEncodingException e) {
                                                e.printStackTrace();
                                            }
                                        }

                                        @Override
                                        public void failed(Throwable exc, ByteBuffer attachment) {

                                            try {
                                                client.close();
                                                latch.countDown();
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
                            client.close();
                            latch.countDown();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

    @Override
    public void failed(Throwable exc, AIOTimeClientHandler attachment) {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
