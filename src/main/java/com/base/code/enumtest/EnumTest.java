package com.base.code.enumtest;

import java.util.Arrays;

/**
 * 一、枚举类的使用
 * 1.枚举类的理解：类的对象只有有限多个，确定的，我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式。
 * <p>
 * 二、如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0之后，可以使用enum关键字定义枚举类
 * <p>
 * 三、Enum类中的常用方法
 * values():返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值
 * valueOf(String str):可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象
 * toString():返回当前枚举类对象常量的名称
 * <p>
 * 四、使用enum关键字定义的枚举类实现接口的情况
 * 情况一：实现接口，在enum类中实现抽象方法
 * 情况二：
 *
 * @author yhc
 * @date 2019-08-26 9:34
 */
public class EnumTest {

    public static void main(String[] args) {
        test02();
    }

    public static void test02() {
        EnumSeason spring = EnumSeason.SPRING;
        EnumSeason summer = EnumSeason.SUMMER;
        EnumSeason autumn = EnumSeason.AUTUMN;
        EnumSeason winter = EnumSeason.WINTER;

        EnumSeason[] values = EnumSeason.values();
        System.out.println(Arrays.toString(values));

        EnumSeason s = EnumSeason.valueOf("SPRING");
        System.out.println(s);

    }

    public static void test01() {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }

}

class Season {

    // 1.声明Season对象的属性

    private final String seasonName;
    private final String seasonDesc;

    // 2.私有化类的构造器,并给对象属性赋值

    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3.提供当前枚举类的多个对象 public static final

    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冬天雪地");

    // 4.其它诉求：获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
