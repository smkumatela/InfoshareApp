package com.example.songezo.infoshareapp.services.seestories;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.SeeStories;
import com.example.songezo.infoshareapp.factories.SeeStoriesFactory;
import com.example.songezo.infoshareapp.services.seestories.Impl.SeeStoriesServiceImpl;

import junit.framework.Assert;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class SeeStoriesServiceTest extends AndroidTestCase {

    private SeeStoriesServiceImpl seeStoriesServiceImpl;
    private boolean isBound;
    private static final String TAG="SEESTORIES TEST";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), SeeStoriesServiceImpl.class);
        App.context = this.getContext();
        seeStoriesServiceImpl = SeeStoriesServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            SeeStoriesServiceImpl.SeeStorieserviceLocalBinder binder
                    = (SeeStoriesServiceImpl.SeeStorieserviceLocalBinder)service;
            seeStoriesServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    public void testCreateEntities() throws Exception {

        SeeStories createEntity = SeeStoriesFactory.createSeeStoriesFactory("Shared Story",11525L);
        SeeStories newEntity = seeStoriesServiceImpl.saveSeeStories(createEntity);
        Assert.assertNotNull(TAG + " CREATE", newEntity);
    }
}
