package com.wanted.onepeople.dao;

import com.wanted.onepeople.model.City;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiyouquedongxing
 * @date 2018/8/8 20:15
 */
public interface MybatisDemoMapper {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City getCity(@Param("cityName") String cityName);

}
