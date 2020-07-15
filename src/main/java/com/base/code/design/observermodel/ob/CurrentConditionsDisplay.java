package com.base.code.design.observermodel.ob;

import com.base.code.design.observermodel.subject.Subject;

/**
 * @author yhc
 * @create 2020-07-10 14:11
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;

    private float humidity;

    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        // 注册
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionsDisplay:temperature" + temperature + ",humidity" + humidity);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
