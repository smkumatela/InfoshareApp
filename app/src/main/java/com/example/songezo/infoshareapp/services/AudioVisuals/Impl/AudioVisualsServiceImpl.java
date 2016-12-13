package com.example.songezo.infoshareapp.services.AudioVisuals.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.AudioVisuals;
import com.example.songezo.infoshareapp.repository.AudioVisuals.AudioVisualsRepository;
import com.example.songezo.infoshareapp.repository.AudioVisuals.Impl.AudioVisualsImpl;

import java.util.Set;

/**
 * Created by VERNON on 2016/12/13.
 */
public class AudioVisualsServiceImpl extends Service implements com.example.songezo.infoshareapp.services.AudioVisuals.AudioVisualsService {

    private AudioVisualsRepository repository;

    private final IBinder localBinder = new AudioVisualsServiceLocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    private static AudioVisualsServiceImpl service = null;

    public AudioVisualsServiceImpl() {

        repository = new AudioVisualsImpl(App.getAppContext());
    }

    public static AudioVisualsServiceImpl getInstance() {
        if (service == null)
            service = new AudioVisualsServiceImpl();
        return service;
    }
    public class AudioVisualsServiceLocalBinder extends Binder {
        public AudioVisualsServiceImpl getService() {
            return AudioVisualsServiceImpl.this;
        }
    }

    @Override
    public AudioVisuals getAudioVisualsByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public AudioVisuals saveAudioVisuals(AudioVisuals entity)
    {
        return repository.save(entity);
    }

    public Set<AudioVisuals> findAll()
    {
        return repository.findAll();
    }
}
