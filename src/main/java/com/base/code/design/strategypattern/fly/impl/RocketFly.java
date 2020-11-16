package com.base.code.design.strategypattern.fly.impl;

import com.base.code.design.strategypattern.fly.FlyBehavior;

/**
 * @author yhc
 * @create 2020-06-12 15:11
 */
public class RocketFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i can fly like rocket...");
    }
}
