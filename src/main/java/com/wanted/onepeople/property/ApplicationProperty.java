package com.wanted.onepeople.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 功能描述：项目配置
 *
 * @author xiyouquedongxing
 * @Date 2020-08-03
 */
@Data
@Component
public class ApplicationProperty {

    @Value("${application.name}")
    private String name;
    @Value("${application.version}")
    private String version;

}
