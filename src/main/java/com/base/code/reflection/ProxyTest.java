package com.base.code.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author yhc
 * @create 2019-12-31 15:23
 */
public class ProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        // 代理类的对象
        Human human = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = human.getBelief();
        System.out.println(belief);
        human.eat("shit");

        System.out.println("************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory clothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        clothFactory.produceCloth();
    }

}

interface Human {
    String getBelief();

    void eat(String food);
}

/**
 * 被代理类
 */
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "i believe i can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("超人吃：" + food);
    }
}

/**
 * 要想实现动态代理，需要解决的问题
 * 1.如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
 * 2.当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法。
 */
class ProxyFactory {

    /**
     * 调用此方法返回一个代理类的对象
     *
     * @param obj 被代理类的对象
     * @return 代理类对象
     * @author yhc
     * @date 2019/12/31 15:37
     */
    static Object getProxyInstance(Object obj) {
        MyInvocationHandler invocationHandler = new MyInvocationHandler();
        invocationHandler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), invocationHandler);
    }

}

class MyInvocationHandler implements InvocationHandler {

    /**
     * 需要使用被代理类的对象进行赋值
     */
    private Object obj;

    void bind(Object obj) {
        this.obj = obj;
    }

    /**
     * 当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法
     * 将被代理类要执行的方法a的功能声明在此方法中
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke...");
        Object result = method.invoke(obj, args);
        System.out.println("after invoke...");
        return result;
    }
}
