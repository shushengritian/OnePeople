package com.wanted.onepeople.test;

/**
 * 功能描述：
 *
 * @author Fdc
 * @Date 2020-06-12
 */
public class MyThreadThree extends Thread {

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("MyThreadThree心跳运行...");
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
