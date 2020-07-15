package com.base.code.extendstest;

/**
 * @author yhc
 * @date 2019-06-26 10:03
 */
public class Fu {

    int a;
    int b;

    public Fu() {
        System.out.println("fu-01");
    }

    public Fu(int a) {
        this.a = a;
        System.out.println("fu-02");
    }

    public void fuMethod01() {
        System.out.println("父-方法-1");
    }

    void fuMethod02() {
        fuMethod01();
        fuMethod03();
        System.out.println("父-方法-2");
    }

    private void fuMethod03() {
        System.out.println("父-方法-3");
    }
}
