package com.wanted.onepeople.test;

/**
 * 功能描述：
 *
 * @author Fdc
 * @Date 2020-06-12
 */
public class MyThreadOne extends Thread{

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("MyThreadOne心跳运行.");
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
