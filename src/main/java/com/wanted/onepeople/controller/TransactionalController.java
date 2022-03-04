package com.wanted.onepeople.controller;

import com.wanted.onepeople.service.TransactionalAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author fdc
 * @Date 2022-03-03
 */
@RestController
@RequestMapping("/transactional")
public class TransactionalController {

    @Autowired
    private TransactionalAService transactionalAService;

    @GetMapping("/test")
    public void testTransactional(){
        transactionalAService.updateEmail();
    }


}
