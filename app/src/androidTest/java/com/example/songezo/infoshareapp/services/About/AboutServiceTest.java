package com.example.songezo.infoshareapp.services.About;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.About;
import com.example.songezo.infoshareapp.factories.AboutFactory;
import com.example.songezo.infoshareapp.services.About.Impl.AboutServiceImpl;

import junit.framework.Assert;

/**
 * Created by VERNON on 2016/12/14.
 */
public class AboutServiceTest extends AndroidTestCase {

    private AboutServiceImpl aboutServiceImpl;
    private boolean isBound;
    private static final String TAG="ABOUT TEST";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), AboutServiceImpl.class);
        App.context = this.getContext();
        aboutServiceImpl = AboutServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            AboutServiceImpl.AboutServiceLocalBinder binder
                    = (AboutServiceImpl.AboutServiceLocalBinder)service;
            aboutServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    public void testCreateEntities() throws Exception {

        About createEntity = AboutFactory.createAbout("Infoshare", 22225L);
        About newEntity = aboutServiceImpl.saveAbout(createEntity);
        Assert.assertNotNull(TAG + " CREATE", newEntity);
    }
}
