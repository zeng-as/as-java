package com.as.io.socket;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author as.
 * @since 2020/11/24
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8090);
//            serverSocket.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
