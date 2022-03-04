package com.wanted.onepeople.service.impl;

import com.wanted.onepeople.repository.UserDao;
import com.wanted.onepeople.service.TransactionalBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author fdc
 * @Date 2022-03-03
 */
@Service
public class TransactionalBServiceImpl implements TransactionalBService {

    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.MANDATORY)
    public void updateName(Long id, String name){
        userDao.findById(id).ifPresent(user -> {
            user.setName(name);
            userDao.save(user);
        });
        int i = 1/0;
    }
}
