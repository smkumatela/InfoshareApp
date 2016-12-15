package com.example.songezo.infoshareapp.services.Weather;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Weather;
import com.example.songezo.infoshareapp.factories.WeatherFactory;
import com.example.songezo.infoshareapp.services.Weather.Impl.WeatherServiceImpl;

import junit.framework.Assert;

/**
 * Created by Mandisi on 12/14/2016.
 */

public class WeatherServiceTest extends AndroidTestCase {

    private WeatherServiceImpl weatherServiceImpl;
    private boolean isBound;
    private static final String TAG="ORGANISATION TEST";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), WeatherServiceImpl.class);
        App.context = this.getContext();
        weatherServiceImpl = WeatherServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            WeatherServiceImpl.WeatherServiceLocalBinder binder
                    = (WeatherServiceImpl.WeatherServiceLocalBinder)service;
            weatherServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    public void testCreateEntities() throws Exception {

        Weather createEntity = WeatherFactory.createWeatherFactory(789654L);
        Weather newEntity = weatherServiceImpl.saveWeather(createEntity);
        Assert.assertNotNull(TAG + " CREATE", newEntity);
    }
}

