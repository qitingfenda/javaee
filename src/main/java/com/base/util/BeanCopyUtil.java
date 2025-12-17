package com.base.util;

import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSON;
import com.base.util.beans.TestBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yhc
 * @create 2023-05-25 9:08
 */
public class BeanCopyUtil {

    public static void main(String[] args) {
        beanCopy(TestBean.class, "data");
    }

    public static void beanCopy(Class<?> cls, String sourceName) {

        Field[] fieldList = cls.getDeclaredFields();
        for (Field field : fieldList) {
            field.setAccessible(Boolean.TRUE);
            String fieldName = field.getName();
            System.out.println("this." + fieldName + " = " + sourceName + ".get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1) + "();");
//            System.out.println("eaCustomerPo.set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1) + "(" + sourceName + ".get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1) + "());");
        }
        // super set
//        for (Field field : fieldList) {
//            field.setAccessible(Boolean.TRUE);
//            String fieldName = field.getName();
//            System.out.println("super.set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1) + "(" + sourceName + ".get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1) + "());");
//        }
    }

    @Test
    public void test02() {
        LocalDate date = LocalDate.parse("2024-5-2", DateTimeFormatter.ofPattern("yyyy-M-d"));
        String format = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(format);
    }


    public static List<CmpUserVoModel> serialize(List<Map<String, String>> mapList) {
        ObjectMapper mapper = new ObjectMapper();
        return mapList.stream()
                .map(map -> mapper.convertValue(map, CmpUserVoModel.class))
                .collect(Collectors.toList());
    }

    @Test
    public void test03()  {
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map = new HashMap<>(16);
        map.put("id","123");
        map.put("uphone","1817");
        mapList.add(map);
        List<CmpUserVoModel> serialize = serialize(mapList);
        System.out.println(serialize);
    }


}
