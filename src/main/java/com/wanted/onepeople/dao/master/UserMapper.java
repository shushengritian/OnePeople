package com.wanted.onepeople.dao.master;

import com.wanted.onepeople.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author xiyouquedongxing
 * @date 2018/8/14 15:03
 */
@Component
public interface UserMapper {

    /**
     * 根据id，查询用户信息
     *
     * @param id
     */
    User getUserById(@Param("id") Long id);
}
