package com.yfm.rpcdemo.producer;

import com.yfm.rpcdemo.producer.Imp.UserService;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author yangFangMin
 * @Date 2021/8/28
 * @Todo
 */
public class MyServerSocket {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8080;
        try (
                //设置请求长度为 3
                ServerSocket serverSocket = new ServerSocket(port,3, InetAddress.getByName(host));

        ){
            while (true) {
                Socket server = serverSocket.accept();
                handle(server);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handle(Socket server) {
        try(
                OutputStream outputStream = server.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        ) {
            IUserService userService = new UserService();
            User user = userService.getUserByName("1");
            objectOutputStream.writeObject(user);
            System.out.println("服务端消息发送完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
