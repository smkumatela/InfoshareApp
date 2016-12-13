package com.example.songezo.infoshareapp.services.Audio.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Audio;
import com.example.songezo.infoshareapp.repository.Audio.AudioRepository;
import com.example.songezo.infoshareapp.repository.Audio.Impl.AudioRepositoryImpl;
import com.example.songezo.infoshareapp.services.Audio.AudioService;

import java.util.Set;

/**
 * Created by VERNON on 2016/12/13.
 */
public class AudioServiceImpl extends Service implements AudioService {

    private AudioRepository repository;

    private final IBinder localBinder = new AudioServiceLocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    private static AudioServiceImpl service = null;

    public AudioServiceImpl() {

        repository = new AudioRepositoryImpl(App.getAppContext());
    }

    public static AudioServiceImpl getInstance() {
        if (service == null)
            service = new AudioServiceImpl();
        return service;
    }
    public class AudioServiceLocalBinder extends Binder {
        public AudioServiceImpl getService() {
            return AudioServiceImpl.this;
        }
    }

    @Override
    public Audio getAudioByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public Audio saveAudio(Audio entity)
    {
        return repository.save(entity);
    }

    public Set<Audio> findAll()
    {
        return repository.findAll();
    }
}
