package com.wanted.onepeople.service.impl;

import com.wanted.onepeople.dao.MybatisDemoMapper;
import com.wanted.onepeople.dao.cluster.CityMapper;
import com.wanted.onepeople.dao.master.UserMapper;
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
    private UserMapper userMapper;

    @Autowired
    private CityMapper cityMapper;

    @Override
    public User getUserById(Long id) {

        User user = userMapper.getUserById(id);
        City city = cityMapper.getCityByName("广州市");
        user.setCity(city);
        return user;
    }
}
