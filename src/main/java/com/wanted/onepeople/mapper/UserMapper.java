package com.wanted.onepeople.mapper;

import com.wanted.onepeople.entity.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description: 用户mapper
 * @Author fdc
 * @Date 2021-03-05
 */
public interface UserMapper extends Mapper<User>, MySqlMapper<User> {
}
