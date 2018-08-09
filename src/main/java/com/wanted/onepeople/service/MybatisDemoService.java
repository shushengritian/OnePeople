package com.wanted.onepeople.service;

import com.wanted.onepeople.model.City;
import com.wanted.onepeople.model.User;

/**
 * @author xiyouquedongxing
 * @date 2018/8/8 20:12
 */
public interface MybatisDemoService {

    /**
     * 根据id，查询用户
     * @param id
     */
     User getUserById(Long id);
}
