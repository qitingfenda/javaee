package com.base.util;

import org.junit.Test;

/**
 * @author yhc
 * @create 2023-08-15 13:46
 */
public class GenerSql {

    public static final String 名称前缀 = "营业成本-纸板生产成本-其他费用-";

    public static void main(String[] args) {
        String unit = "万元";
        String 字段名 = "Produce Other Expenses";

        String 字段类型长度 = " varchar(300) ";
        String[] 字段名arr = 字段名.trim().split(" ");
        for (int i = 0; i < 字段名arr.length; i++) {
            String x = 字段名arr[i];
            字段名arr[i] = x.substring(0, 1).toLowerCase() + x.substring(1);
        }
        String 处理后的字段名 = String.join("_", 字段名arr);
        StringBuilder sql = new StringBuilder("ADD COLUMN ")
                .append(处理后的字段名)
                .append(" ").append(字段类型长度)
                .append("NULL COMMENT '")
                .append(名称前缀)
                .append("(").append(unit).append(")")
                .append("',");
        System.out.println(sql);

    }

    @Test
    public void test价税合计() {
        String 字段名 = "transport cost";
        String unit = "万元";
        String 字段类型长度 = " varchar(300) ";
        String[] 字段名arr = 字段名.trim().split(" ");
        for (int i = 0; i < 字段名arr.length; i++) {
            String x = 字段名arr[i];
            字段名arr[i] = x.substring(0, 1).toLowerCase() + x.substring(1);
        }
        String 处理后的字段名 = String.join("_", 字段名arr);
        StringBuilder sql = new StringBuilder("ADD COLUMN ")
                .append(处理后的字段名).append("_total_tax_price")
                .append(" ").append(字段类型长度)
                .append("NULL COMMENT '")
                .append(名称前缀)
                .append("价税合计")
                .append("(").append(unit).append(")")
                .append("',").append("\n")

                .append("ADD COLUMN ")
                .append(处理后的字段名).append("_total_exclude_tax")
                .append(" ").append(字段类型长度)
                .append("NULL COMMENT '")
                .append(名称前缀)
                .append("不含税合计")
                .append("(").append(unit).append(")")
                .append("';");
        System.out.println(sql);
    }

    @Test
    public void test单位成本以及价税合计() {
        String 字段名 = "Produce Other Expenses";

        String costUnit = "万元";
        String unit = "万元";

        String 字段类型长度 = " varchar(300) ";
        String[] 字段名arr = 字段名.trim().split(" ");
        for (int i = 0; i < 字段名arr.length; i++) {
            String x = 字段名arr[i];
            字段名arr[i] = x.substring(0, 1).toLowerCase() + x.substring(1);
        }
        String 处理后的字段名 = String.join("_", 字段名arr);
        StringBuilder sql = new StringBuilder("ADD COLUMN ")
                .append(处理后的字段名).append("_unit_cost")
                .append(" ").append(字段类型长度)
                .append("NULL COMMENT '")
                .append(名称前缀)
                .append("单位成本")
                .append("(").append(costUnit).append(")")
                .append("',").append("\n")

                .append("ADD COLUMN ")
                .append(处理后的字段名).append("_total_tax_price")
                .append(" ").append(字段类型长度)
                .append("NULL COMMENT '")
                .append(名称前缀)
                .append("价税合计")
                .append("(").append(unit).append(")")
                .append("',").append("\n")

                .append("ADD COLUMN ")
                .append(处理后的字段名).append("_total_exclude_tax")
                .append(" ").append(字段类型长度)
                .append("NULL COMMENT '")
                .append(名称前缀)
                .append("不含税合计")
                .append("(").append(unit).append(")")
                .append("';");
        System.out.println(sql);
    }
}
