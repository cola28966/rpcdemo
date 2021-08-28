package com.yfm.rpcdemo.consumer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author yangFangMin
 * @Date 2021/8/28
 * @Todo
 */
public class ClientSocket {


    public static void main(String[] args) {
        int port = 8080;
        try (
                ServerSocket serverSocket = new ServerSocket(port);
                Socket client = serverSocket.accept();
                InputStream inputStream = client.getInputStream();
                Reader reader = new InputStreamReader(inputStream)
        ){
            //监听端口
            char[] temp = new char[1024];
            int len;
            StringBuilder stringBuilder = new StringBuilder();
            while ((len = reader.read(temp)) != -1 ) {
                stringBuilder.append(new String(temp,0,len));
            }
            System.out.println("客户端收到的消息 : " + stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
