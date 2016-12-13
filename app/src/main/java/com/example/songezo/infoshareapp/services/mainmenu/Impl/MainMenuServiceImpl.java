package com.example.songezo.infoshareapp.services.mainmenu.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.MainMenu;
import com.example.songezo.infoshareapp.repository.mainmenu.Impl.MainMenuRepositoryImpl;
import com.example.songezo.infoshareapp.repository.mainmenu.MainMenuRepository;
import com.example.songezo.infoshareapp.services.mainmenu.MainMenuService;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class MainMenuServiceImpl extends Service implements MainMenuService {

    private MainMenuRepository repository;

    private final IBinder localBinder = new MainMenuServiceLocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    private static MainMenuServiceImpl service = null;

    public MainMenuServiceImpl() {

        repository = new MainMenuRepositoryImpl(App.getAppContext());
    }

    public static MainMenuServiceImpl getInstance() {
        if (service == null)
            service = new MainMenuServiceImpl();
        return service;
    }
    public class MainMenuServiceLocalBinder extends Binder {
        public MainMenuServiceImpl getService() {
            return MainMenuServiceImpl.this;
        }
    }

    @Override
    public MainMenu getMainMenuByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public MainMenu saveMainMenu(MainMenu entity)
    {
        return repository.save(entity);
    }

    public Set<MainMenu> findAll()
    {
        return repository.findAll();
    }
}
