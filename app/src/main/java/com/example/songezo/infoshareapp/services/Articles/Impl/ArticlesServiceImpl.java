package com.example.songezo.infoshareapp.services.Articles.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Articles;
import com.example.songezo.infoshareapp.repository.Articles.ArticlesRepository;
import com.example.songezo.infoshareapp.repository.Articles.Impl.ArticlesRepositoryImpl;
import com.example.songezo.infoshareapp.services.Articles.ArticlesService;

import java.util.Set;

/**
 * Created by VERNON on 2016/12/13.
 */
public class ArticlesServiceImpl extends Service implements ArticlesService {

    private ArticlesRepository repository;

    private final IBinder localBinder = new ArticlesServiceLocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    private static ArticlesServiceImpl service = null;

    public ArticlesServiceImpl() {

        repository = new ArticlesRepositoryImpl(App.getAppContext());
    }

    public static ArticlesServiceImpl getInstance() {
        if (service == null)
            service = new ArticlesServiceImpl();
        return service;
    }
    public class ArticlesServiceLocalBinder extends Binder {
        public ArticlesServiceImpl getService() {
            return ArticlesServiceImpl.this;
        }
    }

    @Override
    public Articles getArticlesByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public Articles saveArticles(Articles entity)
    {
        return repository.save(entity);
    }

    public Set<Articles> findAll()
    {
        return repository.findAll();
    }
}
