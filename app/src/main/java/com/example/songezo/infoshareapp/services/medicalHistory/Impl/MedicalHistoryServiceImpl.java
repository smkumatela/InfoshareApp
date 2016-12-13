package com.example.songezo.infoshareapp.services.medicalHistory.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.MedicalHistory;
import com.example.songezo.infoshareapp.repository.medicalHistory.Impl.MedicalHistoryRepositoryImpl;
import com.example.songezo.infoshareapp.repository.medicalHistory.MedicalHistoryRepository;
import com.example.songezo.infoshareapp.services.medicalHistory.MedicalHistoryService;

import java.util.Set;

/**
 * Created by Songezo on 2016-12-13.
 */
public class MedicalHistoryServiceImpl extends Service implements MedicalHistoryService {

    private MedicalHistoryRepository repository;

    private final IBinder localBinder = new MedicalHistoryServiceLocalBinder();

    private static MedicalHistoryServiceImpl service = null;

    public MedicalHistoryServiceImpl() {
        repository = new MedicalHistoryRepositoryImpl(App.getAppContext());
    }

    public static MedicalHistoryServiceImpl getInstance(){
        if (service == null)
            service = new MedicalHistoryServiceImpl();
        return service;
    }

    public class MedicalHistoryServiceLocalBinder extends Binder{
        public MedicalHistoryServiceImpl getService(){
            return MedicalHistoryServiceImpl.this;
        }
    }

    @Override
    public MedicalHistory getMedicalHistoryByID(Long id) {
        if (repository.findById(id) == null)
        return null;
        else
            return repository.findById(id);
    }

    @Override
    public MedicalHistory saveMedicalHistory(MedicalHistory entity) {
        return repository.save(entity);
    }

    @Override
    public Set<MedicalHistory> findAll() {
        return repository.findAll();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }
}
