package com.example.songezo.infoshareapp.services.About.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.About;
import com.example.songezo.infoshareapp.repository.About.AboutRepository;
import com.example.songezo.infoshareapp.repository.About.Impl.AboutRepositoryImpl;
import com.example.songezo.infoshareapp.services.About.AboutService;

import java.util.Set;

/**
 * Created by VERNON on 2016/12/13.
 */
public class AboutServiceImpl extends Service implements AboutService {

    private AboutRepository repository;

    private final IBinder localBinder = new AboutServiceLocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    private static AboutServiceImpl service = null;

    public AboutServiceImpl() {

        repository = new AboutRepositoryImpl(App.getAppContext());
    }

    public static AboutServiceImpl getInstance() {
        if (service == null)
            service = new AboutServiceImpl();
        return service;
    }
    public class AboutServiceLocalBinder extends Binder {
        public AboutServiceImpl getService() {
            return AboutServiceImpl.this;
        }
    }

    @Override
    public About getAboutByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public About saveAbout(About entity)
    {
        return repository.save(entity);
    }

    public Set<About> findAll()
    {
        return repository.findAll();
    }
}
