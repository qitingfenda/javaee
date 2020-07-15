package com.base.code.design.observermodel;

import com.base.code.design.observermodel.ob.CurrentConditionsDisplay2;
import com.base.code.design.observermodel.subject.WeatherData2;

/**
 * @author yhc
 * @create 2020-07-10 14:45
 */
public class Main2 {
    public static void main(String[] args) {
        WeatherData2 weatherData2 = new WeatherData2();
        CurrentConditionsDisplay2 currentConditionsDisplay2 = new CurrentConditionsDisplay2(weatherData2);
        weatherData2.setMeasurements(11,22,33);
        weatherData2.setMeasurements(4,5,6);
    }
}
