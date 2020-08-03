package com.wanted.onepeople.learning.io;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能描述：IO 模拟服务器
 *
 * @author Fdc
 * @Date 2020-07-28
 */
public class IOServer {

    public static void main(String[] args) {
        //模拟服务器，读取数据
        try {
            ServerSocket serverSocket = new ServerSocket(3333);

            new Thread(() -> {
                while (true){
                    try{
                        Socket socket = serverSocket.accept();
                        new Thread(() -> {
                            try{
                                int len;
                                byte[] data = new byte[1024];
                                InputStream inputStream = socket.getInputStream();
                                while ((len = inputStream.read(data)) != -1){
                                    System.out.println(new String(data, 0, len));
                                }
                            }catch (IOException e){
                                e.printStackTrace();
                            }
                        }).start();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();



        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
