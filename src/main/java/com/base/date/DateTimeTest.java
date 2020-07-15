package com.base.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @author yhc
 * @date 2019-08-08 15:08
 */
public class DateTimeTest {

    public static void main(String[] args) {
        test03();
    }

    public static void test03() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();

        // 日期-->字符串
        String str = formatter.format(localDateTime);
        System.out.println(str);

        // 字符串-->日期
        TemporalAccessor parse = formatter.parse(str);
        System.out.println(parse);

        // 格式化自定义格式
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String str2 = formatter2.format(localDateTime);
        System.out.println(str2);
    }

    public static void test02() {
        // 根据本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        // 添加时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        // 获取时间戳
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        // 通过时间戳获取实例
        Instant instant1 = Instant.ofEpochMilli(milli);
        System.out.println(instant1);
    }

    public static void test01() {
        // now():获取当前的时间日期
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        System.out.println("------------------");

        // of():设置指定的年月日时分秒-没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, 8, 20, 15, 43, 0);
        System.out.println(localDateTime1);

        System.out.println("------------------");

        // getXxx():获取
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        System.out.println("------------------");

        // withXxx():设置相关的属性 不可变性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime2);
        LocalDateTime localDateTime3 = localDateTime.withHour(4);
        System.out.println(localDateTime3);

        System.out.println("------------------");

        // plusXxx:加运算
        LocalDateTime localDateTime4 = localDateTime.plusMonths(3);
        System.out.println(localDateTime4);

        System.out.println("------------------");

        // minusXxx:减运算
        LocalDateTime localDateTime5 = localDateTime.minusHours(1);
        System.out.println(localDateTime5);

    }


    /**
     * java.util.Date类
     * |--java.sql.Date类
     */
    private static void method01() {

    }

}
