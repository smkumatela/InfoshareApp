package com.example.songezo.infoshareapp.services.myPatient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.MyPatient;
import com.example.songezo.infoshareapp.factories.MyPatientFactory;
import com.example.songezo.infoshareapp.services.myPatient.Impl.MyPatientServiceImpl;

import junit.framework.Assert;

import java.sql.Time;
import java.util.Date;
import java.util.Map;

/**
 * Created by Songezo on 2016-12-13.
 */
public class MyPatientServiceTest extends AndroidTestCase{

    Map<String, String> values;
    Long id;
    Date date;
    Time time;

    private MyPatientServiceImpl myPatientServiceImpl;
    private boolean isBound;
    private static final String TAG ="MY PATIENT TEST";

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), MyPatientServiceImpl.class);
        App.context = this.getContext();
        myPatientServiceImpl = MyPatientServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyPatientServiceImpl.MyPatientServiceLocalBinder binder
                    = (MyPatientServiceImpl.MyPatientServiceLocalBinder)service;
            myPatientServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    public void testCreateEntities() throws Exception {

        values.put("comments about Medical History", "Comments");
        values.put("tasks to be done", "task");
        id = 12350L;
        MyPatient myPatientEntity = MyPatientFactory.createMyPatient(values, date, time);
        MyPatient newMyPatient = myPatientServiceImpl.saveMyPatient(myPatientEntity);
        Assert.assertNotNull(TAG + " CREATE", newMyPatient);
    }

}
