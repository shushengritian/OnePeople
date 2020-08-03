package com.wanted.onepeople.learning.io;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.*;

/**
 * 功能描述：IO，模拟客户端
 *
 * @author Fdc
 * @Date 2020-07-28
 */
public class IOClient {

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(()-> {
            try {
                Socket socket = new Socket("127.0.0.1",3333);
                while (true){
                    try {
                        socket.getOutputStream().write((new Date() + "Hello World").getBytes());
                        Thread.sleep(2000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        singleThreadPool.shutdown();

    }

}
