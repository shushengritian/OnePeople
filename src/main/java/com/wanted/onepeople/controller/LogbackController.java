package com.wanted.onepeople.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：logback 测试类控制器
 *
 * @author xiyouquedongxing
 * @Date 2020-08-06
 */
@RestController
public class LogbackController {

    Logger logger = LoggerFactory.getLogger(getClass());

    private Logger myLogger = LoggerFactory.getLogger("MY_LOG");

    @GetMapping("/testLog")
    public void testLog(){
        logger.info("testLogger");
        myLogger.info("testMyLogger");
    }

    @GetMapping("/myLogger")
    public String myLogger(){
        myLogger.info("myLogger");
        return "success";
    }
}
