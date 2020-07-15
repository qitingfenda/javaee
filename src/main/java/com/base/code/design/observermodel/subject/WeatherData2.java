package com.base.code.design.observermodel.subject;

import java.util.Observable;

/**
 * @author yhc
 * @create 2020-07-10 14:37
 */
public class WeatherData2 extends Observable {
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

    /**
     * 测量值已改变时调用
     */
    public void mesurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        mesurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
