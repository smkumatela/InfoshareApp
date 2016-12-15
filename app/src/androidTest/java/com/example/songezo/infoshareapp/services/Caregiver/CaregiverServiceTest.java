package com.example.songezo.infoshareapp.services.Caregiver;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Caregiver;
import com.example.songezo.infoshareapp.factories.CaregiverFactory;
import com.example.songezo.infoshareapp.services.Caregiver.Impl.CaregiverServiceImpl;

import junit.framework.Assert;

/**
 * Created by Mandisi on 12/14/2016.
 */

public class CaregiverServiceTest extends AndroidTestCase {

    private CaregiverServiceImpl caregiverServiceImpl;
    private boolean isBound;
    private static final String TAG="CAREGIVER TEST";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), CaregiverServiceImpl.class);
        App.context = this.getContext();
        caregiverServiceImpl = CaregiverServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            CaregiverServiceImpl.CaregiverServiceLocalBinder binder
                    = (CaregiverServiceImpl.CaregiverServiceLocalBinder)service;
            caregiverServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    public void testCreateEntities() throws Exception {

        Caregiver createEntity = CaregiverFactory.createCaregiverFactory(789654L);
        Caregiver newEntity = caregiverServiceImpl.saveCaregiver(createEntity);
        Assert.assertNotNull(TAG + " CREATE", newEntity);
    }
}

