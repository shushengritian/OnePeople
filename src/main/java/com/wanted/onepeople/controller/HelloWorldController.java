package com.wanted.onepeople.controller;


import com.wanted.onepeople.util.IdGeneratorSnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiyouquedongxing
 * @date 2018/7/23 22:34
 */
@RestController
public class HelloWorldController {

    @Autowired
    private IdGeneratorSnowFlakeUtil idGeneratorSnowFlakeUtil;

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/snowFlake")
    public String snowFlake(){
        for (int i = 1; i <= 100; i++) {
            System.out.println(idGeneratorSnowFlakeUtil.getSnowFlakeId());
        }
        return "hello snowflake";
    }

}
