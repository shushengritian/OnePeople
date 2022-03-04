package com.wanted.onepeople.service.impl;

import com.wanted.onepeople.repository.UserDao;
import com.wanted.onepeople.service.TransactionalAService;
import com.wanted.onepeople.service.TransactionalBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author fdc
 * @Date 2022-03-03
 */
@Service
public class TransactionalAServiceImpl implements TransactionalAService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TransactionalBService transactionalBService;


    public void updateEmail() {

        userDao.findById(1L).ifPresent(user -> {
            user.setEmail("emailccc");
            userDao.save(user);
        });
        try {
            transactionalBService.updateName(2L, "cccc");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
