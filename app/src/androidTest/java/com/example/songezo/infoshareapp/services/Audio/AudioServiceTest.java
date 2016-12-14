package com.example.songezo.infoshareapp.services.Audio;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Audio;
import com.example.songezo.infoshareapp.factories.AudioFactory;
import com.example.songezo.infoshareapp.services.Audio.Impl.AudioServiceImpl;

import junit.framework.Assert;

/**
 * Created by VERNON on 2016/12/14.
 */
public class AudioServiceTest extends AndroidTestCase {

    private AudioServiceImpl audioServiceImpl;
    private boolean isBound;
    private static final String TAG="AUDIO TEST";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), AudioServiceImpl.class);
        App.context = this.getContext();
        audioServiceImpl = AudioServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            AudioServiceImpl.AudioServiceLocalBinder binder
                    = (AudioServiceImpl.AudioServiceLocalBinder)service;
            audioServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    public void testCreateEntities() throws Exception {

        Audio createEntity = AudioFactory.createAudio("track",  42225L);
        Audio newEntity = audioServiceImpl.saveAudio(createEntity);
        Assert.assertNotNull(TAG + " CREATE", newEntity);
    }
}
