package com.bin.server;

import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer2 {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务启动，监听" + 8888 + "端口");

        while (!Thread.interrupted()) {
            // 不停接受客户端请求
            Socket client = server.accept();
            new Thread(new ServerThread(client)).start();
        }
        server.close();
    }
}
