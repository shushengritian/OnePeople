package com.wanted.onepeople.service;

import com.wanted.onepeople.model.City;

/**
 * @author xiyouquedongxing
 * @date 2018/8/8 20:12
 */
public interface MybatisDemoService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    public City getCity(String cityName);
}
