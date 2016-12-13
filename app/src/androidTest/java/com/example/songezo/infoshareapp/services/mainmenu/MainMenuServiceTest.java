package com.example.songezo.infoshareapp.services.mainmenu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.MainMenu;
import com.example.songezo.infoshareapp.factories.MainMenuFactory;
import com.example.songezo.infoshareapp.services.mainmenu.Impl.MainMenuServiceImpl;

import junit.framework.Assert;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class MainMenuServiceTest extends AndroidTestCase {

    private MainMenuServiceImpl mainmenuserviceImpl;
    private boolean isBound;
    private static final String TAG="MAINMENU TEST";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), MainMenuServiceImpl.class);
        App.context = this.getContext();
        mainmenuserviceImpl = MainMenuServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MainMenuServiceImpl.MainMenuServiceLocalBinder binder
                    = (MainMenuServiceImpl.MainMenuServiceLocalBinder)service;
            mainmenuserviceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    public void testCreateEntities() throws Exception {

        MainMenu createEntity = MainMenuFactory.createMainMenuFactory("Ash","badpass","Msg Cont","Saw Storie","MyExtras", 12225L);
        MainMenu newEntity = mainmenuserviceImpl.saveMainMenu(createEntity);
        Assert.assertNotNull(TAG + " CREATE", newEntity);
    }
}
