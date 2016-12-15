package com.example.songezo.infoshareapp.services.Caregiver.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Caregiver;
import com.example.songezo.infoshareapp.repository.Caregiver.CaregiverRepository;
import com.example.songezo.infoshareapp.repository.Caregiver.Impl.CaregiverRepositoryImpl;
import com.example.songezo.infoshareapp.services.Caregiver.CaregiverService;

import java.util.Set;

/**
 * Created by Mandisi on 12/14/2016.
 */

public class CaregiverServiceImpl extends Service implements CaregiverService {

        private CaregiverRepository repository;

        private final IBinder localBinder = new CaregiverServiceLocalBinder();
        @Override
        public IBinder onBind(Intent intent) {
            // TODO: Return the communication channel to the service.
            return localBinder;
        }

        private static CaregiverServiceImpl service = null;

        public CaregiverServiceImpl() {

            repository = new CaregiverRepositoryImpl(App.getAppContext());
        }

    public static CaregiverServiceImpl getInstance() {
        if (service == null)
            service = new CaregiverServiceImpl();
        return service;
    }
    public class CaregiverServiceLocalBinder extends Binder {
        public CaregiverServiceImpl getService() {
            return CaregiverServiceImpl.this;
        }
    }

    @Override
    public Caregiver getCaregiverByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public Caregiver saveCaregiver(Caregiver entity)
    {
        return repository.save(entity);
    }

    public Set<Caregiver> findAll()
    {
        return repository.findAll();
    }
}

