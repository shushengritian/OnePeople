package com.wanted.onepeople.mapper;

import com.wanted.onepeople.entity.OrmUser;
import com.wanted.onepeople.entity.OrmUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface OrmUserMapper {
    long countByExample(OrmUserExample example);

    int deleteByExample(OrmUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrmUser record);

    int insertSelective(OrmUser record);

    List<OrmUser> selectByExample(OrmUserExample example);

    OrmUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrmUser record, @Param("example") OrmUserExample example);

    int updateByExample(@Param("record") OrmUser record, @Param("example") OrmUserExample example);

    int updateByPrimaryKeySelective(OrmUser record);

    int updateByPrimaryKey(OrmUser record);
}