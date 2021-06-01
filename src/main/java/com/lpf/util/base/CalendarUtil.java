package com.lpf.util.base;

import java.util.*;

/**
 * @author lipiaofei
 * @date 2020/01/06 10:13
 * 日历相关操作
 */
public class CalendarUtil {

    /**
     * Calendar工具类中的周与我们生活中的周的每一天的对应
     * Calendar中是按照国外的生活习惯定的（周日~周六，周日为一周的开始，周六为一周的结束）
     */
    private static Map<Integer, Integer> weekDayMapper = new HashMap<>();

    static {
        weekDayMapper.put(2, 1);
        weekDayMapper.put(3, 2);
        weekDayMapper.put(4, 3);
        weekDayMapper.put(5, 4);
        weekDayMapper.put(6, 5);
        weekDayMapper.put(7, 6);
        weekDayMapper.put(1, 7);
    }

    /**
     * 获取指定年月的每一周的实际天数
     * @param weekDayMapper Calendar与实际的周 每一天的映射
     * @param year          年份
     * @param month         月份
     * @return 所有周的实际天数的list集合
     */
    public static List<Integer> getAllWeekDaysOfMonth(Map<Integer, Integer> weekDayMapper, int year, int month) {
        List<Integer> weekDays = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        // Calendar中的月份为 0 ~ 11
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int firstDayOfWeek = weekDayMapper.get(calendar.get(Calendar.DAY_OF_WEEK));

        int firstWeekDays = 8 - firstDayOfWeek;
        weekDays.add(firstWeekDays);
        int residue = maxDay - firstWeekDays;

        int fullWeeks = residue / 7;
        for (int i = 0; i < fullWeeks; i++) {
            weekDays.add(7);
        }
        int residueDay = residue % 7;
        if (residueDay != 0) {
            weekDays.add(residueDay);
        }

        return weekDays;
    }

}
