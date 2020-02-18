package com.lazy.demo.io.client;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/16.
 * {@link com.lazy.demo.io.server.NIOTimeServer}
 */
public class NIOTimeClient {


    public static void main(String[] args) {

        new Thread(
                new NIOTimeClientHandler("localhost", 8088),
                "Time Client Thread"
        ).start();
    }
}
