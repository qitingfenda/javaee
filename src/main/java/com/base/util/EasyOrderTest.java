package com.base.util;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author yhc
 * @create 2024-01-25 14:44
 */
public class EasyOrderTest {
    @Test
    public void test01() {
        LocalDateTime now = LocalDateTime.now();
        LocalTime localTime = now.toLocalTime();
        System.out.println(localTime);
        LocalTime startTime = LocalTime.parse("08:00", DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime endTime = LocalTime.parse("08:59:59", DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(startTime+"-"+endTime);
        int i = localTime.compareTo(endTime);
        System.out.println(i);
    }
}
