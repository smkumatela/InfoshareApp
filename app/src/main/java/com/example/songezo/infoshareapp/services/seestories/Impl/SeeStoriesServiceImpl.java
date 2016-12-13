package com.example.songezo.infoshareapp.services.seestories.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.SeeStories;
import com.example.songezo.infoshareapp.repository.seestories.Impl.SeeStoriesRepositoryImpl;
import com.example.songezo.infoshareapp.repository.seestories.SeeStoriesRepository;
import com.example.songezo.infoshareapp.services.seestories.SeeStoriesService;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class SeeStoriesServiceImpl extends Service implements SeeStoriesService {

    private SeeStoriesRepository repository;

    private final IBinder localBinder = new SeeStorieserviceLocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    private static SeeStoriesServiceImpl service = null;

    public SeeStoriesServiceImpl() {

        repository = new SeeStoriesRepositoryImpl(App.getAppContext());
    }

    public static SeeStoriesServiceImpl getInstance() {
        if (service == null)
            service = new SeeStoriesServiceImpl();
        return service;
    }
    public class SeeStorieserviceLocalBinder extends Binder {
        public SeeStoriesServiceImpl getService() {
            return SeeStoriesServiceImpl.this;
        }
    }

    @Override
    public SeeStories getSeeStoriesByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public SeeStories saveSeeStories(SeeStories entity)
    {
        return repository.save(entity);
    }

    public Set<SeeStories> findAll()
    {
        return repository.findAll();
    }
}
