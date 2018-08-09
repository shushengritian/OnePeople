package com.wanted.onepeople.dao;

import com.wanted.onepeople.model.City;
import com.wanted.onepeople.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiyouquedongxing
 * @date 2018/8/8 20:15
 */
public interface MybatisDemoMapper {

    /**
     * 根据id，查询用户信息
     *
     * @param id
     */
    User getUserById(@Param("id") Long id);

}
