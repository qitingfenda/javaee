package com.base.code.other;

/**
 * 接口的使用
 * 1.接口使用interface来定义
 * 2.Java中，接口和类是并列的两个结构
 * 3.如何定义接口，定义接口中的成员
 * >JDK7及以前，只能定义全局常量和抽象方法
 * >>全局常量：public static final ,书写时可以省略
 * >>抽象方法：public abstract ,书写时可以省略
 * >JDK8及以后，还能定义静态方法和默认方法
 * >>1.接口中定义的静态方法，只能通过接口来调用
 * >>2.通过实现类的对象，可以调用接口中的默认方法
 * >>3.如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
 * >>4.如果一个类继承的父类和实现的接口中声明了同名同参数的默认方法，
 * >>那么子类在调用该方法时，调用的是父类的方法。 --类优先原则
 * >>5.如果一个类实现的多个接口中定义了同名同参数的默认方法，
 * >>则该类子没有重写该方法的情况下，则编译报错。 --接口冲突
 * >>6.调用接口中的默认方法：类名.super.方法名
 * 4.接口中不能定义构造器，意味着接口不可以实例化
 * 5.Java开发中，接口通过类去实现(implements)的方式来使用
 * >如果实现类覆盖了接口中所有的抽象方法，则此类就可以实例化
 * >如果实现类没有覆盖接口中的所有抽象方法，则此类仍是抽象类
 * 6.Java类可以实现多个接口-->弥补了Java单继承的局限性
 * 7.接口与接口之间可以继承，而且可以多继承
 * 8.接口的具体使用，体现多态性
 * 9.接口，实际上可以看做是一种规范
 *
 * @author yhc
 * @date 2019-07-01 14:49
 */
public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);
    }
}

interface Flyable {
    int MAX_SPEED = 7900;
    int MIN_SPEED = 1;

    void fly();

    void stop();
}

class Plane implements Flyable {
    @Override
    public void fly() {
    }

    @Override
    public void stop() {
    }
}