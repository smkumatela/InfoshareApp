package com.example.songezo.infoshareapp.services.organisation.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Organisation;
import com.example.songezo.infoshareapp.repository.organisation.Impl.OrganisationRepositoryImpl;
import com.example.songezo.infoshareapp.repository.organisation.OrganisationRepository;
import com.example.songezo.infoshareapp.services.organisation.OrganisationService;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class OrganisationServiceImpl extends Service implements OrganisationService {

    private OrganisationRepository repository;

    private final IBinder localBinder = new OrganisationServiceLocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    private static OrganisationServiceImpl service = null;

    public OrganisationServiceImpl() {

        repository = new OrganisationRepositoryImpl(App.getAppContext());
    }

    public static OrganisationServiceImpl getInstance() {
        if (service == null)
            service = new OrganisationServiceImpl();
        return service;
    }
    public class OrganisationServiceLocalBinder extends Binder {
        public OrganisationServiceImpl getService() {
            return OrganisationServiceImpl.this;
        }
    }

    @Override
    public Organisation getOrganisationByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public Organisation saveOrganisation(Organisation entity)
    {
        return repository.save(entity);
    }

    public Set<Organisation> findAll()
    {
        return repository.findAll();
    }
}
