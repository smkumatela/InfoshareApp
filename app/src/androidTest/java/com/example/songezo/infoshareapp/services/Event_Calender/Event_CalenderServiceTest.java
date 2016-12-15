package com.example.songezo.infoshareapp.services.Event_Calender;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Event_Calender;
import com.example.songezo.infoshareapp.factories.Event_CalenderFactory;
import com.example.songezo.infoshareapp.services.Event_Calender.Impl.Event_CalenderServiceImpl;

import junit.framework.Assert;

/**
 * Created by Mandisi on 12/14/2016.
 */

public class Event_CalenderServiceTest extends AndroidTestCase {

    private Event_CalenderServiceImpl event_CalenderServiceImpl;
    private boolean isBound;
    private static final String TAG="EVENT_CALENDAR TEST";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), Event_CalenderServiceImpl.class);
        App.context = this.getContext();
        event_CalenderServiceImpl = Event_CalenderServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Event_CalenderServiceImpl.Event_CalenderserviceLocalBinder binder
                    = (Event_CalenderServiceImpl.Event_CalenderserviceLocalBinder)service;
            event_CalenderServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    public void testCreateEntities() throws Exception {

        Event_Calender createEntity = Event_CalenderFactory.createEvent_CalenderFactory("Organization Story",11525L);
        Event_Calender newEntity = event_CalenderServiceImpl.saveEvent_Calender(createEntity);
        Assert.assertNotNull(TAG + " CREATE", newEntity);
    }
}
