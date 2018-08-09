package com.wanted.onepeople.service.impl;

import com.wanted.onepeople.dao.MybatisDemoMapper;
import com.wanted.onepeople.model.City;
import com.wanted.onepeople.model.User;
import com.wanted.onepeople.service.MybatisDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiyouquedongxing
 * @date 2018/8/8 20:12
 */
@Service
public class MybatisDemoServiceImpl implements MybatisDemoService {

    @Autowired
    private MybatisDemoMapper demoMapper;

    @Override
    public User getUserById(Long id) {

        return demoMapper.getUserById(id);
    }
}
