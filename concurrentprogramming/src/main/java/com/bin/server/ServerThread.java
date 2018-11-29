package com.bin.server;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ServerThread implements Runnable {

    private static Map<String, String> contentMap = new HashMap<>();

    static {
        contentMap.put("html", "text/html;charset=utf-8");
        contentMap.put("jpg", "image/jpeg");
    }

    private Socket client;
    private InputStream ins;
    private OutputStream out;
    private PrintWriter pw;
    private BufferedReader br;

    public ServerThread(Socket client) {
        this.client = client;
        init();
    }

    private void init() {
        // 获取输入流
        try {
            ins = client.getInputStream();
            out = client.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String WEBROOT = "/Users/jiangjiabin/desktop/";

    private void go() throws Exception {

        // 读取请求内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
        String line = reader.readLine().split(" ")[1];
        System.out.println(line);

        if (line.equals("/")) {
            line += "index.html";
        }

        // 给用户响应
        PrintWriter pw = new PrintWriter(out);

        InputStream i = new FileInputStream(WEBROOT + line);
//        BufferedReader fr = new BufferedReader(new InputStreamReader(i));
        // 响应格式
        pw.println("HTTP/1.1 200 OK");
        pw.println("Content-Type: " + contentMap.get(line.substring(line.lastIndexOf(".") + 1)));
        pw.println("Content-Length: " + i.available());
        pw.println("Server: hello");
        pw.println("Date:" + new Date());
        pw.println("");
        pw.flush();

        byte[] buff = new byte[1024];
        int len;

        while ((len = i.read(buff)) != -1) {
            out.write(buff, 0, len);
        }
        pw.flush();

//        fr.close();
//        pw.close();
//        reader.close();
//
//        client.close();

    }
}
