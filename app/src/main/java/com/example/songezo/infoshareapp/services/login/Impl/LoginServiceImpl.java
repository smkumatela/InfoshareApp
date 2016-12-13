package com.example.songezo.infoshareapp.services.login.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Login;
import com.example.songezo.infoshareapp.repository.login.Impl.LoginRepositoryImpl;
import com.example.songezo.infoshareapp.repository.login.LoginRepository;
import com.example.songezo.infoshareapp.services.login.LoginService;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class LoginServiceImpl extends Service implements LoginService {

    private LoginRepository repository;

    private final IBinder localBinder = new LoginServiceLocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    private static LoginServiceImpl service = null;

    public LoginServiceImpl() {

        repository = new LoginRepositoryImpl(App.getAppContext());
    }

    public static LoginServiceImpl getInstance() {
        if (service == null)
            service = new LoginServiceImpl();
        return service;
    }
    public class LoginServiceLocalBinder extends Binder {
        public LoginServiceImpl getService() {
            return LoginServiceImpl.this;
        }
    }

    @Override
    public Login getLoginByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public Login saveLogin(Login entity)
    {
        return repository.save(entity);
    }

    public Set<Login> findAll()
    {
        return repository.findAll();
    }


}
