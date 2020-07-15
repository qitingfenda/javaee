package com.base.code.design.strategypattern;

import com.base.code.design.strategypattern.duck.Duck;
import com.base.code.design.strategypattern.duck.childs.SuperDuck;
import com.base.code.design.strategypattern.fly.impl.NoFly;

/**
 * 策略设计模式
 *
 * @author yhc
 * @create 2020-06-12 15:00
 */
public class Main {

    public static void main(String[] args) {
        Duck duck = new SuperDuck();
//        duck.setFlyBehavior(new NoFly());
        duck.fly();
    }

}
