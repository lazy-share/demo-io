package com.lazy.demo.io.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/15.
 */
public class NIOTimeServerHandler implements Runnable {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;

    public NIOTimeServerHandler(int port) {

        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("The time server start in port: " + port);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                selector.select(5000);
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeySet.iterator();

                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();

                    try {
                        handlerInput(key);
                    } catch (Exception e) {
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void handlerInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            if (key.isAcceptable()) {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();

                sc.configureBlocking(false);

                sc.register(selector, SelectionKey.OP_READ);

            }

            if (key.isReadable()) {
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBytes];
                    readBuffer.get(bytes);

                    String body = new String(bytes, "UTF-8");

                    System.out.println("The time server receive body: " + body);

                    String currentTime = "get time".equalsIgnoreCase(body) ? LocalDateTime.now().toString() : "param error";

                    doWrite(sc, currentTime);

                } else if (readBytes < 0) {
                    key.cancel();
                    sc.close();
                } else {

                }
            }
        }
    }

    private void doWrite(SocketChannel channel, String content) throws IOException {

        if (content != null && content.trim().length() > 0) {
            byte[] bytes = content.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);

        }
    }
}
