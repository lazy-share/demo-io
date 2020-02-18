package com.lazy.demo.io.server;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/15.
 * {@link com.lazy.demo.io.client.NIOTimeClient}
 */
public class NIOTimeServer {

    public static void main(String[] args) {

        new Thread(new NIOTimeServerHandler(8088)).start();
    }

}
