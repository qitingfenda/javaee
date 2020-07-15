package com.base.code.reflection;

/**
 * 静态代理
 * 特点：代理类和被代理类在编译期间，就确下来了
 *
 * @author yhc
 * @create 2019-12-31 13:47
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        NikeClothFactory nike = new NikeClothFactory();
        ProxyClothFactory clothFactory = new ProxyClothFactory(nike);
        clothFactory.produceCloth();
    }

}

interface ClothFactory {
    void produceCloth();
}

/**
 * 代理类
 */
class ProxyClothFactory implements ClothFactory {

    /**
     * 用被代理类对象进行实例化
     */
    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂的一些准备工作...");
        factory.produceCloth();
        System.out.println("代理工厂的一些后续工作...");
    }
}

/**
 * 被代理类
 */
class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("nike工厂生产衣服...");
    }

}
