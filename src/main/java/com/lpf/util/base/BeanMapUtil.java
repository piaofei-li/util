package com.lpf.util.base;

import org.springframework.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lipiaofei
 * @date 2019/07/29 15:39
 * javabean 与 map 之间的相互转换
 */
public class BeanMapUtil {

    /**
     * 将对象装换为map
     *
     * @param bean javabean对象
     * @return 转换后的map集合
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 将map装换为javabean对象
     *
     * @param map 需要进行转换的map
     * @param bean javabean对象
     * @return javabean对象
     */
    public static <T> T mapToBean(Map<String, Object> map, T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }
}
