package com.example.songezo.infoshareapp.services.sharestories.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.ShareStories;
import com.example.songezo.infoshareapp.repository.sharestories.Impl.ShareStoriesRepositoryImpl;
import com.example.songezo.infoshareapp.repository.sharestories.ShareStoriesRepository;
import com.example.songezo.infoshareapp.services.sharestories.ShareStoriesService;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class ShareStoriesServiceImpl extends Service implements ShareStoriesService {

    private ShareStoriesRepository repository;

    private final IBinder localBinder = new ShareStoriesserviceLocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    private static ShareStoriesServiceImpl service = null;

    public ShareStoriesServiceImpl() {

        repository = new ShareStoriesRepositoryImpl(App.getAppContext());
    }

    public static ShareStoriesServiceImpl getInstance() {
        if (service == null)
            service = new ShareStoriesServiceImpl();
        return service;
    }
    public class ShareStoriesserviceLocalBinder extends Binder {
        public ShareStoriesServiceImpl getService() {
            return ShareStoriesServiceImpl.this;
        }
    }

    @Override
    public ShareStories getShareStoriesByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public ShareStories saveShareStories(ShareStories entity)
    {
        return repository.save(entity);
    }

    public Set<ShareStories> findAll()
    {
        return repository.findAll();
    }
}
