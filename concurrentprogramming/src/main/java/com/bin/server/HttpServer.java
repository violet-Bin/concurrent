package com.bin.server;

import sun.misc.Cleaner;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HttpServer {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务启动，监听" + 8888 + "端口");

        while (!Thread.interrupted()) {
            // 不停接受客户端请求
            Socket client = server.accept();

            // 获取输入流
            InputStream ins = client.getInputStream();
            OutputStream out = client.getOutputStream();

            // 读取请求内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            String line = reader.readLine();
            System.out.println(line);

            // 给用户响应
            PrintWriter pw = new PrintWriter(out);

            InputStream i = new FileInputStream("/Users/jiangjiabin/desktop/index.html");
            BufferedReader fr = new BufferedReader(new InputStreamReader(i));
            // 响应格式
            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type: text/html;charset=utf-8");
            pw.println("Content-Length: " + i.available());
            pw.println("Server: hello");
            pw.println("Date:" + new Date());
            pw.println("");
            pw.flush();

            String c;
            while ((c = fr.readLine()) != null) {
                pw.print(c);
            }
            pw.flush();

            fr.close();
            pw.close();
            reader.close();

            client.close();
        }

    }

}
