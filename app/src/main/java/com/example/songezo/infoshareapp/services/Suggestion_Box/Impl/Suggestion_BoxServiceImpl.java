package com.example.songezo.infoshareapp.services.Suggestion_Box.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Suggestion_Box;
import com.example.songezo.infoshareapp.repository.Suggestion_Box.Impl.Suggestion_BoxRepositoryImpl;
import com.example.songezo.infoshareapp.repository.Suggestion_Box.Suggestion_BoxRepository;
import com.example.songezo.infoshareapp.services.Suggestion_Box.Suggestion_BoxService;

import java.util.Set;

/**
 * Created by Mandisi on 12/14/2016.
 */

public class Suggestion_BoxServiceImpl extends Service implements Suggestion_BoxService {

    private Suggestion_BoxRepository repository;

    private final IBinder localBinder = new OrganisationServiceLocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    private static Suggestion_BoxServiceImpl service = null;

    public Suggestion_BoxServiceImpl() {

        repository = new Suggestion_BoxRepositoryImpl(App.getAppContext());
    }

    public static Suggestion_BoxServiceImpl getInstance() {
        if (service == null)
            service = new Suggestion_BoxServiceImpl();
        return service;
    }
    public class OrganisationServiceLocalBinder extends Binder {
        public Suggestion_BoxServiceImpl getService() {
            return Suggestion_BoxServiceImpl.this;
        }
    }

    @Override
    public Suggestion_Box getSuggestion_BoxByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public Suggestion_Box saveSuggestion_Box(Suggestion_Box entity)
    {
        return repository.save(entity);
    }

    public Set<Suggestion_Box> findAll()
    {
        return repository.findAll();
    }
}
