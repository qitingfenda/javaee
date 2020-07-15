package com.base.code.design.strategypattern.duck.childs;

import com.base.code.design.strategypattern.duck.Duck;
import com.base.code.design.strategypattern.fly.impl.RocketFly;

/**
 * @author yhc
 * @create 2020-06-12 15:16
 */
public class SuperDuck extends Duck {
    @Override
    public void display() {
        System.out.println("i look like super man...");
    }

    public SuperDuck () {
        setFlyBehavior(new RocketFly());
    }

}
