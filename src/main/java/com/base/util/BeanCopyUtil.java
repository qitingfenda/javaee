package com.base.util;

import cn.hutool.core.util.NumberUtil;
import com.base.util.beans.TestBean;
import org.junit.Test;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author yhc
 * @create 2023-05-25 9:08
 */
public class BeanCopyUtil {

    public static void main(String[] args) {
        beanCopy(TestBean.class, "po");
    }

    public static void beanCopy(Class<?> cls, String sourceName) {
        Field[] fieldList = cls.getDeclaredFields();
        for (Field field : fieldList) {
            field.setAccessible(Boolean.TRUE);
            String fieldName = field.getName();
            System.out.println("this." + fieldName + " = " + sourceName + ".get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1) + "();");
        }
    }

    @Test
    public void test02() {
        String format = new DecimalFormat("#.##").format(new BigDecimal("2.084"));
        new DecimalFormat("#.##").setRoundingMode(RoundingMode.DOWN);

        String str = NumberUtil.decimalFormat("#.##", new BigDecimal("0.085"));
        System.out.println(format);
        System.out.println(str);
    }
}
