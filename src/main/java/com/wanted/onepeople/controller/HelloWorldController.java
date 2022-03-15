package com.wanted.onepeople.controller;


import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author xiyouquedongxing
 * @date 2018/7/23 22:34
 */
@RestController
public class HelloWorldController {


    private RedissonClient redissonClient;

    @Autowired
    public HelloWorldController(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/redisson")
    public String testRedisson(){
        //获取分布式锁，只要锁的名字一样，就是同一把锁
        RLock lock = redissonClient.getLock("lock");

        //加锁（阻塞等待），默认过期时间是30秒
        lock.lock();
        try{
            //如果业务执行过长，Redisson会自动给锁续期
            Thread.sleep(1000);
            System.out.println("加锁成功，执行业务逻辑");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //解锁，如果业务执行完成，就不会继续续期，即使没有手动释放锁，在30秒过后，也会释放锁
            lock.unlock();
        }

        return "Hello Redisson!";
    }

    @GetMapping("/testLock")
    public String TestLock() {
        // 1.获取锁，只要锁的名字一样，获取到的锁就是同一把锁。
        RLock lock = redissonClient.getLock("bwky-mt");

        // 2.加锁
        lock.lock(8, TimeUnit.SECONDS);
        try {
            System.out.println("加锁成功，执行后续代码。线程 ID：" + Thread.currentThread().getId());
            Thread.sleep(10000);
        } catch (Exception e) {
            //TODO
        } finally {
            try {
                lock.unlock();
            }catch (Exception e){
                System.out.println("手动释放报错！");
            }
            // 3.解锁
            System.out.println("Finally，释放锁成功。线程 ID：" + Thread.currentThread().getId());
        }

        return "test lock ok";
    }

}
