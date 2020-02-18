package com.lazy.demo.io.server;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/16.
 * {@link com.lazy.demo.io.client.AIOTimeClient}
 */
public class AIOTimeServer {


    public static void main(String[] args) {

        new Thread(
                new AIOTimeServerHandler(8088)
        ).start();
    }
}
