package com.wanted.onepeople;


import cn.hutool.core.collection.CollUtil;
import com.wanted.onepeople.entity.User;
import com.wanted.onepeople.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OnePeopleApplicationTests {

    @Autowired
    private UserMapper mapper;

    @Test
    public void selectAll(){

        List<User> userList = mapper.selectAll();
        Assert.assertTrue(CollUtil.isNotEmpty(userList));
        log.debug("【userList】= {}", userList);
    }
}
