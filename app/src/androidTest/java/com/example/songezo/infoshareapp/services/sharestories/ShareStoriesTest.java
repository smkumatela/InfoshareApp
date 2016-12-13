package com.example.songezo.infoshareapp.services.sharestories;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.ShareStories;
import com.example.songezo.infoshareapp.factories.ShareStoriesFactory;
import com.example.songezo.infoshareapp.services.sharestories.Impl.ShareStoriesServiceImpl;

import junit.framework.Assert;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class ShareStoriesTest extends AndroidTestCase {

    private ShareStoriesServiceImpl shareStoriesServiceImpl;
    private boolean isBound;
    private static final String TAG="SHARESTORIES TEST";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), ShareStoriesServiceImpl.class);
        App.context = this.getContext();
        shareStoriesServiceImpl = ShareStoriesServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ShareStoriesServiceImpl.ShareStoriesserviceLocalBinder binder
                    = (ShareStoriesServiceImpl.ShareStoriesserviceLocalBinder)service;
            shareStoriesServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    public void testCreateEntities() throws Exception {

        ShareStories createEntity = ShareStoriesFactory.createShareStoriesFactory("Cleared","Shared", 11545L);
        ShareStories newEntity = shareStoriesServiceImpl.saveShareStories(createEntity);
        Assert.assertNotNull(TAG + " CREATE", newEntity);
    }

}
