package com.wanted.onepeople.repository;

import com.wanted.onepeople.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述：User Dao
 *
 * @author xiyouquedongxing
 * @Date 2020-08-17
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

}
