package com.example.songezo.infoshareapp.services.Extras.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Extras;
import com.example.songezo.infoshareapp.repository.Extras.ExtrasRepository;
import com.example.songezo.infoshareapp.repository.Extras.Impl.ExtrasRepositoryImpl;
import com.example.songezo.infoshareapp.services.Extras.ExtrasService;

import java.util.Set;

/**
 * Created by Mandisi on 12/14/2016.
 */

public class ExtrasServiceImpl extends Service implements ExtrasService {

    private ExtrasRepository repository;

    private final IBinder localBinder = new ExtrasServiceLocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    private static ExtrasServiceImpl service = null;

    public ExtrasServiceImpl() {

        repository = new ExtrasRepositoryImpl(App.getAppContext());
    }

    public static ExtrasServiceImpl getInstance() {
        if (service == null)
            service = new ExtrasServiceImpl();
        return service;
    }
    public class ExtrasServiceLocalBinder extends Binder {
        public ExtrasServiceImpl getService() {
            return ExtrasServiceImpl.this;
        }
    }

    @Override
    public Extras getExtrasByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public Extras saveExtras(Extras entity)
    {
        return repository.save(entity);
    }

    public Set<Extras> findAll()
    {
        return repository.findAll();
    }
}
