package com.example.songezo.infoshareapp.services.Weather;

import com.example.songezo.infoshareapp.domain.Weather;

import java.util.Set;

/**
 * Created by Mandisi on 12/14/2016.
 */

public interface WeatherService {
    Weather getWeatherByID(Long id);


    Weather saveWeather(Weather entity);

    Set<Weather> findAll();
}

