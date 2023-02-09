package com.base.code.other;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author yhc
 * @create 2022-08-08 9:12
 */
public class Test05 {

    @Test
    public void test() {
        int hour = LocalDateTime.now().getHour();
        System.out.println(hour);
    }

    private void init(List<String> dataList) {
        for (int i = 0; i < 22; i++) {
            dataList.add(i + "");
        }
    }


    /**
     * 计算两个时间差
     */
    public String getTimeDifference(Date date1, Date date2) {
        StringBuilder df = new StringBuilder();
        // 计算单位设置(毫秒1000 * 秒60 * 分60 * 时24);
        long time = (date1.getTime() - date2.getTime());
        long num = time / (1000 * 60 * 60);
        long num1 = time % (1000 * 60 * 60);
        float temp = (float) (num1 / 1000 / 60) / (float) 60.0;
//        float temp = (num1 / 1000 / 60) / (float) 60.0;
        if (num >= 0) {
            df.append(num + temp);
        }
        return df.toString();

    }


}
