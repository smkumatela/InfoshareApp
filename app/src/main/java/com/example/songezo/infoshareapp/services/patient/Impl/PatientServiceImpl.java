package com.example.songezo.infoshareapp.services.patient.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Patient;
import com.example.songezo.infoshareapp.repository.patient.Impl.PatientRepositoryImpl;
import com.example.songezo.infoshareapp.repository.patient.PatientRepository;
import com.example.songezo.infoshareapp.services.patient.PatientService;

import java.util.Set;

/**
 * Created by Songezo on 2016-12-13.
 */
public class PatientServiceImpl extends Service implements PatientService {

    private PatientRepository repository;

    private final IBinder localBinder = new PatientServiceLocalBinder();

    private static PatientServiceImpl service = null;

    public PatientServiceImpl(){
        repository = new PatientRepositoryImpl(App.getAppContext());
    }

    public static PatientServiceImpl getInstance(){
        if (service == null)
            service = new PatientServiceImpl();
        return service;
    }

    public class PatientServiceLocalBinder extends Binder{
        public PatientServiceImpl getService(){
            return PatientServiceImpl.this;
        }
    }

    @Override
    public Patient getPatientByID(Long id) {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    @Override
    public Patient savePatient(Patient entity) {
        return repository.save(entity);
    }

    @Override
    public Set<Patient> findAll() {
        return repository.findAll();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }
}
