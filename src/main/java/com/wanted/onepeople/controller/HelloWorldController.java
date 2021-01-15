package com.wanted.onepeople.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiyouquedongxing
 * @date 2018/7/23 22:34
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

}
