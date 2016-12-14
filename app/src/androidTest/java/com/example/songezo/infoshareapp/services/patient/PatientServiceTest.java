package com.example.songezo.infoshareapp.services.patient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Patient;
import com.example.songezo.infoshareapp.factories.PatientFactory;
import com.example.songezo.infoshareapp.services.patient.Impl.PatientServiceImpl;

import junit.framework.Assert;

import java.util.Date;
import java.util.Map;

/**
 * Created by Songezo on 2016-12-13.
 */
public class PatientServiceTest extends AndroidTestCase{

    Map<String, String> values;
    Long id;
    Date date;
    boolean gender;

    private PatientServiceImpl patientServiceImpl;
    private boolean isBound;
    private static final String TAG = "PATIENT TEST";

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), PatientServiceImpl.class);
        App.context = this.getContext();
        patientServiceImpl = PatientServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            PatientServiceImpl.PatientServiceLocalBinder binder
                    = (PatientServiceImpl.PatientServiceLocalBinder) service;
            patientServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = true;
        }
    };

    public void testCreatedEntities() throws Exception {
        values.put("residential address", "Residential Address");
        values.put("home Language", "Home Language");
        values.put("first name", "First Name");
        values.put("reason", " Reason for visiting");
        values.put("medicalHistory", "Medical History");
        values.put("toDo", "To do List");
        id = 481216L;
        Patient patientEntity = PatientFactory.createPatient(values, date, gender);
        Patient newPatient = patientServiceImpl.savePatient(patientEntity);
        Assert.assertNotNull(TAG + " CREATE", newPatient);
    }
}
