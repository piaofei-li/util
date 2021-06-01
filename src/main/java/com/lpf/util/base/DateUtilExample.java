package com.lpf.util.base;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * @author lipiaofei
 * @date 2019/07/22 10:23
 * JodaTime时间相关操作示例
 */
public class DateUtilExample {

    public static void main(String[] args) {
        // java.util.date <--> org.joda.time.DateTime
        Date date = new Date();
        DateTime dateTime = new DateTime(date);
        Date newDate = dateTime.toDate();

        // String -> DateTime
        String dateStr = "2021-06-01 14:17:15.999";
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
        DateTime parseDateTime = formatter.parseDateTime(dateStr);

        // DateTime -> String
        DateTime now = DateTime.now();
        String formatDateTime = now.toString("yyyy-MM-dd");

        // plus、minus
        // DateTime time = datetime.plusXxx(n)
        // DateTime time = datetime.minusXxx(n)
        DateTime time = DateTime.now();
        time.plusYears(1);
        time.plusMonths(1);
        time.plusDays(1);
        time.plusHours(1);
        time.plusMinutes(1);
        time.plusSeconds(1);
        time.plusMillis(1);
        time.plus(System.currentTimeMillis());

        time.minusYears(1);
        time.minusMonths(1);
        time.minusDays(1);
        time.minusHours(1);
        time.minusMinutes(1);
        time.minusSeconds(1);
        time.minusMillis(1);
        time.minus(System.currentTimeMillis());
    }
}
