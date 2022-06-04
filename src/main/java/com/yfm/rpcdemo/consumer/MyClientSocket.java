package com.yfm.rpcdemo.consumer;

import com.yfm.rpcdemo.producer.User;

import java.io.*;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author yangFangMin
 * @Date 2021/8/28
 * @Todo
 */
public class MyClientSocket {


    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8080;
        while (true) {
            try (
                    Socket client = new Socket(host,port);
                    InputStream inputStream = client.getInputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            ){
                Object object = objectInputStream.readObject();
                if(object != null) {
                    User user = (User) object;
                    System.out.println("客户端收到的消息 : " + user);
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

}
