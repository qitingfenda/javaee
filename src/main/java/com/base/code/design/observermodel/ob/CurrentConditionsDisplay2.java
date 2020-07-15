package com.base.code.design.observermodel.ob;


import com.base.code.design.observermodel.subject.WeatherData2;

import java.util.Observable;
import java.util.Observer;

/**
 * @author yhc
 * @create 2020-07-10 14:11
 */
public class CurrentConditionsDisplay2 implements Observer, DisplayElement {

    private float temperature;

    private float humidity;

    private Observable observable;

    public CurrentConditionsDisplay2(Observable observable) {
        this.observable = observable;
        // 注册
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionsDisplay:temperature" + temperature + ",humidity" + humidity);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData2) {
            WeatherData2 weatherData2 = (WeatherData2) o;
            this.temperature = weatherData2.getTemperature();
            this.humidity = weatherData2.getHumidity();
            display();
        }
    }
}
