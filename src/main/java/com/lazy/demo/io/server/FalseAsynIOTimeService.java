package com.lazy.demo.io.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/13.
 * {@link com.lazy.demo.io.client.BIOTimeClient}
 */
public class FalseAsynIOTimeService {

    public static void main(String[] args) throws IOException {

        int port = 8088;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("The False Asyn IO Time Server Start...");

            FalseAsynTimeServerHandlerExecutePool executePool = new FalseAsynTimeServerHandlerExecutePool(50, 1000);
            while (true) {
                Socket socket = serverSocket.accept();

                executePool.execute(new BIOTimeServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
                ;
            }
        }

    }
}
