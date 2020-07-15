package com.base.code.extendstest;

/**
 * @author yhc
 * @date 2019-06-26 10:03
 */
public class Zi extends Fu {

    int c;
    int d;

    public Zi() {
        System.out.println("zi-01");
    }

    public Zi(int c) {
        this.c = c;
        System.out.println("zi-02");
    }

    @Override
    public void fuMethod01() {
        System.out.println("子-方法-1");
    }


    public void fuMethod03() {
        System.out.println("子-方法-3");
    }
}
