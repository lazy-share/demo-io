package com.lazy.demo.io.client;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/13.
 * {@link com.lazy.demo.io.server.BIOTimeServer}
 */
public class BIOTimeClient {


    public static void main(String[] args) {

        new BIOTimeClientHandler("localhost", 8088).run();
    }
}
