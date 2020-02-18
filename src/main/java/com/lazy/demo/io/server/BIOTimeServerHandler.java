package com.lazy.demo.io.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/13.
 */
public class BIOTimeServerHandler implements Runnable {

    private Socket socket;
    public BIOTimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String content;
            while (true) {
                content = in.readLine();
                if (content == null) {
                    break;
                }

                System.out.println("Time Server receive content: " + content);
                if (content.equalsIgnoreCase("get time")) {
                    String currentTime = new Date(System.currentTimeMillis()).toString();
                    out.println(currentTime);
                } else {
                    out.println("not found!");
                }
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
