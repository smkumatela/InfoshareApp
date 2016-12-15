package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.Weather;

/**
 * Created by Mandisi on 12/13/2016.
 */

public class WeatherFactory {
    Weather weather;

    private static WeatherFactory weatherFactory = null;

    public WeatherFactory() {
    }

    public static WeatherFactory getLogFactory(){
        if (weatherFactory == null){
            weatherFactory = new WeatherFactory();
        }
        return weatherFactory;
    }

    public static Weather createWeatherFactory(Long id){
        Weather weather1 = new Weather.Builder()
                .id(id)
                .build();

        return weather1;
    }

    @Override
    public String toString() {
        return "weatherFactory{" +
                "weather=" + weather +
                '}';
    }
}

