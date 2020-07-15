package com.base.code.other;

/**
 * abstract关键字的使用
 * 1.abstract:抽象的
 * 2.abstract可以用来修饰的结构：类、方法
 * 3.abstract修饰类：
 * >此类不能实例化
 * >抽象类中一定有构造器，便于子类实例化时调用(涉及：子类对象实例化的全过程)
 * >开发中，都会提供抽象类的子类，让子类对象实例化，完成相关的操作
 * <p>
 * 4.abstract修饰方法：
 * >抽象方法只有方法的声明，没有方法体
 * >包含抽象方法的类一定是抽象类，反之，抽象类中可以没有抽象方法
 * >若子类重写了父类中的所有抽象方法后，此子类方可实例化。若子类没有重写父类中的所有抽象方法，则子类也是抽象类
 * <p>
 * abstract只能修饰类和方法，不能修饰其它结构
 * abstract不能修饰私有方法、静态方法、final方法、final类
 *
 * @author yhc
 * @date 2019-07-01 10:34
 */
public class AbstractTest {

    public static void main(String[] args) {

    }

}
