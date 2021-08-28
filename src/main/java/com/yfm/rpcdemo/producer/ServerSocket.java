package com.yfm.rpcdemo.producer;

import com.yfm.rpcdemo.producer.Imp.UserService;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @Author yangFangMin
 * @Date 2021/8/28
 * @Todo
 */
public class ServerSocket {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8080;
        IUserService userService = new UserService();
        User user = userService.getUserByName("1");
        try (
                Socket server = new Socket(host, port);
                OutputStream outputStream = server.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        ){
            objectOutputStream.writeObject(user);
            System.out.println("服务端消息发送完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
