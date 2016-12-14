package com.example.songezo.infoshareapp.services.Video;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Video;
import com.example.songezo.infoshareapp.factories.VideoFactory;
import com.example.songezo.infoshareapp.services.Video.Impl.VideoServiceImpl;

import junit.framework.Assert;

/**
 * Created by VERNON on 2016/12/14.
 */
public class VideoServiceTest extends AndroidTestCase {

    private VideoServiceImpl videoServiceImpl;
    private boolean isBound;
    private static final String TAG="VIDEO TEST";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), VideoServiceImpl.class);
        App.context = this.getContext();
        videoServiceImpl = VideoServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            VideoServiceImpl.VideoServiceLocalBinder binder
                    = (VideoServiceImpl.VideoServiceLocalBinder)service;
            videoServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    public void testCreateEntities() throws Exception {

        Video createEntity = VideoFactory.createVideo(52225L, "video");
        Video newEntity = videoServiceImpl.saveVideo(createEntity);
        Assert.assertNotNull(TAG + " CREATE", newEntity);
    }
}
