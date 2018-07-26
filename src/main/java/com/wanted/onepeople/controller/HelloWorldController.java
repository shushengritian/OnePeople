package com.wanted.onepeople.controller;

import com.wanted.onepeople.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiyouquedongxing
 * @date 2018/7/23 22:34
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World";
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
