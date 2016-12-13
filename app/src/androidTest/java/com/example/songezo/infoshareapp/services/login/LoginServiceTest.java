package com.example.songezo.infoshareapp.services.login;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Login;
import com.example.songezo.infoshareapp.factories.LoginFactory;
import com.example.songezo.infoshareapp.services.login.Impl.LoginServiceImpl;

import junit.framework.Assert;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class LoginServiceTest extends AndroidTestCase {

    private LoginServiceImpl loginServiceImpl;
    private boolean isBound;
    private static final String TAG="LOGIN TEST";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), LoginServiceImpl.class);
        App.context = this.getContext();
        loginServiceImpl = LoginServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LoginServiceImpl.LoginServiceLocalBinder binder
                    = (LoginServiceImpl.LoginServiceLocalBinder)service;
            loginServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    public void testCreateEntities() throws Exception {

        Login createEntity = LoginFactory.createLoginFactory("Ash","badpass", 12225L);
        Login newEntity = loginServiceImpl.saveLogin(createEntity);
        Assert.assertNotNull(TAG + " CREATE", newEntity);
    }
}
