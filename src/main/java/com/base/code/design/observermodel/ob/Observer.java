package com.base.code.design.observermodel.ob;

/**
 * 观察者接口
 * 所有观察者必须实现此接口，否则不会被通知
 *
 * @author yhc
 * @create 2020-07-10 13:55
 */
public interface Observer {
    /**
     * 当数据改变时，此方法会被调用
     *
     * @param temp
     * @param humidity
     * @param pressure
     * @author yhc
     * @date 2020/7/10 13:56
     */
    void update(float temp, float humidity, float pressure);
}
