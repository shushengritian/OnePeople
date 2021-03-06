package com.wanted.onepeople.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanted.onepeople.entity.User;
import com.wanted.onepeople.mapper.UserMapper;
import com.wanted.onepeople.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author fdc
 * @Date 2021-03-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
