package com.wanted.onepeople.controller;

import com.wanted.onepeople.model.City;
import com.wanted.onepeople.model.User;
import com.wanted.onepeople.service.MybatisDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiyouquedongxing
 * @date 2018/8/8 20:09
 */
@RestController
public class MybatisDemoController {

    @Autowired
    private MybatisDemoService demoService;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public User getUserById(@RequestParam(value = "id",required = true) Long id) {

        return demoService.getUserById(id);

    }

}
