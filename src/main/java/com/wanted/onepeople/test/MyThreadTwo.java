package com.wanted.onepeople.test;


/**
 * 功能描述：
 *
 * @author Fdc
 * @Date 2020-06-12
 */
public class MyThreadTwo extends Thread {

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("MyThreadTwo心跳运行..");
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }




}


