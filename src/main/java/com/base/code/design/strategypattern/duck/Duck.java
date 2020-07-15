package com.base.code.design.strategypattern.duck;

import com.base.code.design.strategypattern.fly.FlyBehavior;

/**
 * 鸭子顶级父类
 *
 * @author yhc
 * @create 2020-06-12 14:59
 */
public abstract class Duck {

    private FlyBehavior flyBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public abstract void display();

    public void fly() {
        this.flyBehavior.fly();
    }

    public void methodA() {
        System.out.println("methodA...");
    }

    public void methodB() {
        System.out.println("methodB...");
    }

    public void methodC() {
        System.out.println("methodC...");
    }

}
