package com.wanted.onepeople.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.wanted.onepeople.annotation.Desensitization;
import com.wanted.onepeople.enumerate.DesensitizationFieldType;
import com.wanted.onepeople.service.DesensitizationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @Description:
 * @Author fdc
 * @Date 2022-03-13
 */
@Slf4j
@Service
public class DesensitizationServiceImpl implements DesensitizationService {


    /**
     * 通过反射获取带注解的值,然后去做脱敏
     *
     * @param objectList 需要脱敏的对象
     * @return 返回处理后的对象
     */
    public List roleDesensitization(List<?> objectList) {
        //list为空,直接返回
        if (CollectionUtil.isEmpty(objectList)) {
            return objectList;
        }
        for (Object object : objectList) {
            // 首先通过反射获取object对象的类有哪些字段
            Field[] fields = object.getClass().getDeclaredFields();
            // for循环逐个字段校验，看哪个字段上标了注解
            for (Field field : fields) {
                // if判断：检查该字段上有没有标注了@Desensit注解
                if (field.isAnnotationPresent(Desensitization.class)) {
                    // 通过反射获取到该字段上标注的@Desensit注解的详细信息
                    Desensitization roleDesensitization = field.getAnnotation(Desensitization.class);
                    DesensitizationFieldType type = roleDesensitization.type();
                    // 让我们在反射时能访问到私有变量
                    field.setAccessible(true);
                    String value;
                    try {
                        // 用过反射获取字段的实际值
                        value = ((String) field.get(object));
                        //拿着value，脱敏类型去做脱敏
                        field.set(object, dealData(value, type.getType()));
                    } catch (Exception e) {
                        log.error("敏感数据处理失败");
                    }
                }
            }
        }
        return objectList;
    }

    /**
     * 公共脱敏方法
     *
     * @param value 需要脱敏的值
     * @param type  脱敏类型
     * @return 返回脱敏后的字符串
     */
    static String dealData(String value, String type) {
        //下面是我自己简单定义的脱敏处理方式
        //把名字第二个字变为*
        if (DesensitizationFieldType.NAME.getType().equals(type) && value.length() > 1) {
            return value.substring(0,1)+"*"+value.substring(2);
        }
        return value;
    }
}
