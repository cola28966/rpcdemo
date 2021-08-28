package com.yfm.rpcdemo.consumer;

import com.yfm.rpcdemo.producer.User;

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
                //监听端口
                ServerSocket serverSocket = new ServerSocket(port);
                Socket client = serverSocket.accept();
                InputStream inputStream = client.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ){
            Object object = objectInputStream.readObject();
            if(object != null) {
                User user = (User) object;
                System.out.println("客户端收到的消息 : " + user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
