package com.wanted.onepeople.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description:
 * @Author fdc
 * @Date 2022-03-28
 */
@Slf4j
@Component
public class IdGeneratorSnowFlakeUtil {

    private long workerId = 0;
    private long datacenterId = 1;
    private Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);

    @PostConstruct
    public void init(){
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workerId：{}", workerId);
        }catch (Exception e){
            e.printStackTrace();
            log.info("获取当前机器的workerId失败");
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    public long getSnowFlakeId(){
        return snowflake.nextId();
    }

    public long getSnowFlakeId(long workerId, long datacenterId){
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }
}
