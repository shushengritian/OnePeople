package com.wanted.onepeople.controller;

import com.wanted.onepeople.model.City;
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
    private MybatisDemoService service;

    @RequestMapping(value = "/api/city",method = RequestMethod.GET)
    public City getCity(@RequestParam(value = "cityName",required = true) String cityName) {

        return service.getCity(cityName);

    }



}
