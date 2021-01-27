package com.wanted.onepeople;

import cn.hutool.core.collection.CollUtil;
import com.wanted.onepeople.entity.OrmUser;
import com.wanted.onepeople.entity.OrmUserExample;
import com.wanted.onepeople.mapper.OrmUserMapper;
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
    private OrmUserMapper mapper;

    @Test
    public void selectAll(){
        OrmUserExample example = new OrmUserExample();
        List<OrmUser> userList = mapper.selectByExample(example);
        Assert.assertTrue(CollUtil.isNotEmpty(userList));
        log.debug("【userList】= {}", userList);
    }

}
