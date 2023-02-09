package com.base.code.other;

import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author yhc
 * @create 2021-12-17 15:05
 */
public class Test04 {

    @Test
    public void test01() {
        BigDecimal 金额 = new BigDecimal("10000");
        List<Integer> 次数列表 = new ArrayList<>();
        List<BigDecimal> 非定投金额列表 = new ArrayList<>();
        List<BigDecimal> 定投金额列表 = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            次数列表.add(i);
            BigDecimal 非定投本金 = new BigDecimal("10000");
            BigDecimal 定投本金 = new BigDecimal("0");
            int 模拟天数 = 10;
            for (int j = 1; j <= 模拟天数; j++) {
                print("第" + j + "天" + "\t");
                // 涨跌率
                BigDecimal 涨跌率 = fluctuation();
                BigDecimal 收益 = 计算收益(非定投本金, 涨跌率);
                print("收益:" + 收益 + "\t");
                // 计算本金
                非定投本金 = 非定投本金.add(收益);
                print("非定投本金:" + 非定投本金 + "\t\n");

                // 定投
                BigDecimal 每天定投金额 = 金额.divide(new BigDecimal(模拟天数), 4, BigDecimal.ROUND_HALF_UP);
                print("第" + j + "天" + "\t" + "定投：" + 每天定投金额 + "\t");
                定投本金 = 定投本金.add(每天定投金额);
                BigDecimal 定投收益 = 计算收益(定投本金, 涨跌率);
                print("定投收益:" + 定投收益 + "\t");
                // 计算本金
                定投本金 = 定投本金.add(定投收益);
                print("定投本金:" + 定投本金 + "\t\n\n");
            }
            System.out.print("----------结算----------" + "\t" + "非定投：" + 非定投本金 + "\t" + "定投：" + 定投本金);
            非定投金额列表.add(非定投本金);
            定投金额列表.add(定投本金);
            System.out.println();
        }
        System.out.println(JSONArray.toJSONString(次数列表));
        String s1 = JSONArray.toJSONString(非定投金额列表);
        System.out.println("非定投金额列表:\n" + s1);
        String s2 = JSONArray.toJSONString(定投金额列表);
        System.out.println("定投金额列表:\n" + s2);
    }

    public void print(String str) {
//        System.out.print(str);
    }

    private BigDecimal 计算收益(BigDecimal 本金, BigDecimal 涨跌率) {
        return 本金.multiply(涨跌率.divide(new BigDecimal("100"), 4, BigDecimal.ROUND_HALF_UP))
                .setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal fluctuation() {
        Random rd = new Random();
        int 最小涨幅 = -3;
        int 最大涨幅 = 4;
        int i = rd.nextInt(最大涨幅 - 最小涨幅 + 1) + 最小涨幅;
        print("涨跌率：" + i + "%" + "\t");
        return new BigDecimal(i);
    }

}
