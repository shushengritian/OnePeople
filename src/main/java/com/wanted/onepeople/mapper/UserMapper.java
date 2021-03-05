package com.wanted.onepeople.mapper;

import com.wanted.onepeople.entity.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description: 用户mapper
 * @Author fdc
 * @Date 2021-03-05
 */
@Component
public interface UserMapper extends Mapper<User>, MySqlMapper<User> {
}
