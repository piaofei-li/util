package com.lpf.util.base;

/**
 * @author lipiaofei
 * @version 1.0
 * @date 2019/07/22 10:21
 * 字符串操作
 */
public class StringUtil {

    /**
     * 判断传入的String对象是否为空
     *
     * @param str String
     * @return 为空返回 true，不为空返回 false
     */
    public static boolean isEmpty(String str) {
        return null == str || str.length() == 0;
    }

    /**
     * 判断传入的String对象是否为空白（空格）
     *
     * @param str String
     * @return 为空白返回 true，不为空白返回 false
     */
    public static boolean isBlank(String str) {
        return null == str || str.trim().length() == 0;
    }

}
