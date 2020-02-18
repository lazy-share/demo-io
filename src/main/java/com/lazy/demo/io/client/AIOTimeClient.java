package com.lazy.demo.io.client;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/16.
 * {@link com.lazy.demo.io.server.AIOTimeServer}
 */
public class AIOTimeClient {


    public static void main(String[] args) {


        new Thread(new AIOTimeClientHandler("localhost", 8088)).start();
    }
}
