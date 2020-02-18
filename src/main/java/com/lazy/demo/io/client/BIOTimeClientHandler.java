package com.lazy.demo.io.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/16.
 */
public class BIOTimeClientHandler {

    private String host;
    private int port;

    public BIOTimeClientHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() {

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            socket = new Socket(host, port);

            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("get time");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String resp = in.readLine();

            if (resp != null) {
                System.out.println("resp: " + resp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                out.close();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
