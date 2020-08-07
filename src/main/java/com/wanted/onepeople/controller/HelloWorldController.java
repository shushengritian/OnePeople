package com.wanted.onepeople.controller;

import com.wanted.onepeople.annotation.DoneTime;
import com.wanted.onepeople.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiyouquedongxing
 * @date 2018/7/23 22:34
 */
@RestController
@Slf4j
public class HelloWorldController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello")
    @DoneTime(param = "helloWorld")
    public String helloWorld(@RequestParam(required = false, name = "who") String who){
        if(StringUtils.isEmpty(who)){
            who = "World";
        }
        log.info("执行Hello World!");
        return "Hello " + who;
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "https://github.com/shushengritian");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
}
