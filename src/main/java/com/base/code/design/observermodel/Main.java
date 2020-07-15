package com.base.code.design.observermodel;

import com.base.code.design.observermodel.ob.CurrentConditionsDisplay;
import com.base.code.design.observermodel.subject.WeatherData;

/**
 * 观察者模式
 *
 * @author yhc
 * @create 2020-07-10 13:54
 */
public class Main {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(11,22,33);
        weatherData.setMeasurements(44,55,66);
    }

}
