package com.example.songezo.infoshareapp.services.Video.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Video;
import com.example.songezo.infoshareapp.repository.Video.Impl.VideoRepositoryImpl;
import com.example.songezo.infoshareapp.repository.Video.VideoRepository;
import com.example.songezo.infoshareapp.services.Video.VideoService;

import java.util.Set;

/**
 * Created by VERNON on 2016/12/13.
 */
public class VideoServiceImpl extends Service implements VideoService {

    private VideoRepository repository;

    private final IBinder localBinder = new VideoServiceLocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    private static VideoServiceImpl service = null;

    public VideoServiceImpl() {

        repository = new VideoRepositoryImpl(App.getAppContext());
    }

    public static VideoServiceImpl getInstance() {
        if (service == null)
            service = new VideoServiceImpl();
        return service;
    }
    public class VideoServiceLocalBinder extends Binder {
        public VideoServiceImpl getService() {
            return VideoServiceImpl.this;
        }
    }

    @Override
    public Video getVideoByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public Video saveVideo(Video entity)
    {
        return repository.save(entity);
    }

    public Set<Video> findAll()
    {
        return repository.findAll();
    }
}
