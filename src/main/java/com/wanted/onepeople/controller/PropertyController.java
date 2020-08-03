package com.wanted.onepeople.controller;

import cn.hutool.core.lang.Dict;
import com.wanted.onepeople.property.ApplicationProperty;
import com.wanted.onepeople.property.DeveloperProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：项目配置测试
 *
 * @author xiyouquedongxing
 * @Date 2020-08-03
 */
@RestController
public class PropertyController {

    private ApplicationProperty applicationProperty;
    private DeveloperProperty developerProperty;

    @Autowired
    public PropertyController(ApplicationProperty applicationProperty,
                              DeveloperProperty developerProperty){
        this.applicationProperty = applicationProperty;
        this.developerProperty = developerProperty;
    }

    @GetMapping("/property")
    public Dict property(){
        return Dict.create().set("applicationProperty",applicationProperty).set("developerProperty", developerProperty);
    }

}
