package com.base.code.design.strategypattern.fly.impl;

import com.base.code.design.strategypattern.fly.FlyBehavior;

/**
 * @author yhc
 * @create 2020-06-12 15:09
 */
public class NoFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i con't fly...");
    }
}
