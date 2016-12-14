package com.example.songezo.infoshareapp.services.AudioVisuals;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.AudioVisuals;
import com.example.songezo.infoshareapp.factories.AudioVisualFactory;
import com.example.songezo.infoshareapp.services.AudioVisuals.Impl.AudioVisualsServiceImpl;

import junit.framework.Assert;

/**
 * Created by VERNON on 2016/12/14.
 */
public class AudioVisualsServiceTest extends AndroidTestCase {

    private AudioVisualsServiceImpl audioVisualsServiceImpl;
    private boolean isBound;
    private static final String TAG="AUDIOVISUALS TEST";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), AudioVisualsServiceImpl.class);
        App.context = this.getContext();
        audioVisualsServiceImpl = AudioVisualsServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            AudioVisualsServiceImpl.AudioVisualsServiceLocalBinder binder
                    = (AudioVisualsServiceImpl.AudioVisualsServiceLocalBinder)service;
            audioVisualsServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    public void testCreateEntities() throws Exception {

        AudioVisuals createEntity = AudioVisualFactory.createAudioVisuals("video", "track", 62225L);
        AudioVisuals newEntity = audioVisualsServiceImpl.saveAudioVisuals(createEntity);
        Assert.assertNotNull(TAG + " CREATE", newEntity);
    }
}
