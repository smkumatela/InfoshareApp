package com.example.songezo.infoshareapp.services.Weather.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Weather;
import com.example.songezo.infoshareapp.repository.Weather.Impl.WeatherRepositoryImpl;
import com.example.songezo.infoshareapp.repository.Weather.WeatherRepository;
import com.example.songezo.infoshareapp.services.Weather.WeatherService;

import java.util.Set;

/**
 * Created by Mandisi on 12/14/2016.
 */

public class WeatherServiceImpl extends Service implements WeatherService {

    private WeatherRepository repository;

    private final IBinder localBinder = new WeatherServiceLocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    private static WeatherServiceImpl service = null;

    public WeatherServiceImpl() {

        repository = new WeatherRepositoryImpl(App.getAppContext());
    }

    public static WeatherServiceImpl getInstance() {
        if (service == null)
            service = new WeatherServiceImpl();
        return service;
    }
    public class WeatherServiceLocalBinder extends Binder {
        public WeatherServiceImpl getService() {
            return WeatherServiceImpl.this;
        }
    }

    @Override
    public Weather getWeatherByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public Weather saveWeather(Weather entity)
    {
        return repository.save(entity);
    }

    public Set<Weather> findAll()
    {
        return repository.findAll();
    }
}
