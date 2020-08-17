package com.wanted.onepeople.repository;

import com.wanted.onepeople.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述：Department Dao
 *
 * @author xiyouquedongxing
 * @Date 2020-08-17
 */
@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {

    /**
     * 根据层级查询部门
     *
     * @param level 层级
     * @return 部门列表
     */
    List<Department> findDepartmentsByLevels(Integer level);

}
