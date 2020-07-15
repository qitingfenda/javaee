package com.base.code.design.observermodel.subject;

import com.base.code.design.observermodel.ob.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 气象数据类
 *
 * @author yhc
 * @create 2020-07-10 14:02
 */
public class WeatherData implements Subject {

    private List<Observer> observers = new ArrayList<>();
    /**
     * 温度
     */
    private float temperature;
    /**
     * 湿度
     */
    private float humidity;
    /**
     * 压力
     */
    private float pressure;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    /**
     * 测量值已改变时调用
     */
    public void mesurementsChanged() {
        notifyObserver();
    }

    public void setMeasurements(float temp,float humidity,float pressure){
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        mesurementsChanged();
    }

}
