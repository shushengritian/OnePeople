package com.wanted.onepeople.learning.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author fdc
 * @Date 2022-03-20
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ExecutorService executorService3 = Executors.newCachedThreadPool();
        ReentrantLock reentrantLock = new ReentrantLock();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Semaphore semaphore = new Semaphore(2);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(() -> {
            threadLocal.set(Thread.currentThread().getName());
            //反射获得当前线程的ThreadLocalMap
            System.out.println(threadLocal.get());
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();

        threadLocal.set(Thread.currentThread().getName());
        //反射获得当前线程的ThreadLocalMap
        System.out.println(threadLocal.get());
    }


}
