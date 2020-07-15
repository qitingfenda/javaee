package com.base.code.design.observermodel.subject;

import com.base.code.design.observermodel.ob.Observer;

/**
 * @author yhc
 * @create 2020-07-10 14:00
 */
public interface Subject {
    /**
     * 注册
     */
    void registerObserver(Observer o);

    /**
     * 移除
     */
    void removeObserver(Observer o);

    /**
     * 通知
     */
    void notifyObserver();
}
