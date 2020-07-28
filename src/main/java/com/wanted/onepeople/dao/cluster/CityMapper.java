package com.wanted.onepeople.dao.cluster;

import com.wanted.onepeople.model.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author xiyouquedongxing
 * @date 2018/8/14 15:03
 */
@Component
public interface CityMapper {

    /**
     * 根据名称，查询城市信息
     *
     * @param cityName
     */
    City getCityByName(@Param("cityName") String cityName);
}
