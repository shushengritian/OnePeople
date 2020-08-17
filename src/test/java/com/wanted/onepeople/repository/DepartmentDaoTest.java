package com.wanted.onepeople.repository;

import cn.hutool.json.JSONUtil;
import com.wanted.onepeople.OnePeopleApplicationTests;
import com.wanted.onepeople.entity.Department;
import com.wanted.onepeople.entity.User;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * 描述：jpa 测试类
 *
 * @author xiyouquedongxing
 * @Date 2020-08-17
 */
@Slf4j
public class DepartmentDaoTest extends OnePeopleApplicationTests {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private UserDao userDao;

    /**
     * 测试保存 ,根节点
     *
     * 注解@Transactional 在单元测试中自带@Rollback(true)，
     * 如需改变数据库添加@Rollback(false)注解
     *
     */
    @Test
    @Transactional

    public void testSave() {
        Collection<Department> departmentList = departmentDao.findDepartmentsByLevels(0);

        if (departmentList.size() == 0) {
            Department testSave1 = Department.builder().name("testSave1").orderNo(0).levels(0).superior(null).build();
            Department testSave1_1 = Department.builder().name("testSave1_1").orderNo(0).levels(1).superior(testSave1).build();
            Department testSave1_2 = Department.builder().name("testSave1_2").orderNo(0).levels(1).superior(testSave1).build();
            Department testSave1_1_1 = Department.builder().name("testSave1_1_1").orderNo(0).levels(2).superior(testSave1_1).build();
            departmentList.add(testSave1);
            departmentList.add(testSave1_1);
            departmentList.add(testSave1_2);
            departmentList.add(testSave1_1_1);
            departmentDao.saveAll(departmentList);

            Collection<Department> deptall = departmentDao.findAll();
            log.info("【部门】= {}", JSONArray.toJSONString((List) deptall));
        }

        userDao.findById(1L).ifPresent(user -> {
            user.setName("添加部门");
            Department dept = departmentDao.findById(2L).get();
            user.setDepartmentList(departmentList);
            userDao.save(user);
        });

        log.info("用户部门={}", JSONUtil.toJsonStr(userDao.findById(1L).get().getDepartmentList()));


        departmentDao.findById(2L).ifPresent(dept -> {
            Collection<User> userlist = dept.getUserList();
            //关联关系由user维护中间表，department userlist不会发生变化，可以增加查询方法来处理  重写getUserList方法
            log.info("部门下用户={}", JSONUtil.toJsonStr(userlist));
        });


        userDao.findById(1L).ifPresent(user -> {
            user.setName("清空部门");
            user.setDepartmentList(null);
            userDao.save(user);
        });
        log.info("用户部门={}", userDao.findById(1L).get().getDepartmentList());

    }

}
