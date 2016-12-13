package com.example.songezo.infoshareapp.services.medicalHistory;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.MedicalHistory;
import com.example.songezo.infoshareapp.factories.MedicalHistoryFactory;
import com.example.songezo.infoshareapp.services.medicalHistory.Impl.MedicalHistoryServiceImpl;

import junit.framework.Assert;

import java.util.Date;
import java.util.Map;

/**
 * Created by Songezo on 2016-12-13.
 */
public class MedicalHistoryServiceTest extends AndroidTestCase {

    Map<String, String> values;
    Long id;
    Date date;

    private MedicalHistoryServiceImpl medicalHistoryServiceImpl;
    private boolean isBound;
    private static final String TAG ="MEDICAL HISTORY TEST";

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), MedicalHistoryServiceImpl.class);
        App.context = this.getContext();
        medicalHistoryServiceImpl = MedicalHistoryServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
        private ServiceConnection connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                MedicalHistoryServiceImpl.MedicalHistoryServiceLocalBinder binder
                        = (MedicalHistoryServiceImpl.MedicalHistoryServiceLocalBinder)service;
                medicalHistoryServiceImpl = binder.getService();
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
            MedicalHistory medicalHistoryEntity = MedicalHistoryFactory.createMedicalHistory(values, date, id);
            MedicalHistory newMedical = medicalHistoryServiceImpl.saveMedicalHistory(medicalHistoryEntity);
            Assert.assertNotNull(newMedical);
        }
    }

