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
 */
public class BIOTimeServer {


    public static void main(String[] args) throws IOException {

        int port = 8088;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("BIO Time Server Start...");

            while (true) {
                Socket socket = serverSocket.accept();

                new Thread(new BIOTimeServerHandler(socket)).start();
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
