package com.example.songezo.infoshareapp.services.myPatient.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.MyPatient;
import com.example.songezo.infoshareapp.repository.myPatient.Impl.MyPatientRepositoryImpl;
import com.example.songezo.infoshareapp.repository.myPatient.MyPatientRepository;
import com.example.songezo.infoshareapp.services.myPatient.MyPatientService;

import java.util.Set;

/**
 * Created by Songezo on 2016-12-13.
 */
public class MyPatientServiceImpl extends Service implements MyPatientService {

    private MyPatientRepository repository;

    private final IBinder localBinder = new MyPatientServiceLocalBinder();

    private static MyPatientServiceImpl service = null;

    public MyPatientServiceImpl(){
        repository = new MyPatientRepositoryImpl(App.getAppContext());
    }

    public static MyPatientServiceImpl getInstance(){
        if (service == null)
            service = new MyPatientServiceImpl();
        return service;
    }

    public class MyPatientServiceLocalBinder extends Binder{
        public MyPatientServiceImpl getService(){
            return MyPatientServiceImpl.this;
        }
    }

    @Override
    public MyPatient getMyPatientByID(Long id) {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    @Override
    public MyPatient saveMyPatient(MyPatient entity) {
        return repository.save(entity);
    }

    @Override
    public Set<MyPatient> findAll() {
        return repository.findAll();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }
}
