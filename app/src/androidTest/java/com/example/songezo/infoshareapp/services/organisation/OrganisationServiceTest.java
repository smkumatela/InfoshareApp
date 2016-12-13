package com.example.songezo.infoshareapp.services.organisation;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Organisation;
import com.example.songezo.infoshareapp.factories.OrganisationFactory;
import com.example.songezo.infoshareapp.services.organisation.Impl.OrganisationServiceImpl;

import junit.framework.Assert;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class OrganisationServiceTest extends AndroidTestCase {

    private OrganisationServiceImpl organisationServiceImpl;
    private boolean isBound;
    private static final String TAG="ORGANISATION TEST";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), OrganisationServiceImpl.class);
        App.context = this.getContext();
        organisationServiceImpl = OrganisationServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            OrganisationServiceImpl.OrganisationServiceLocalBinder binder
                    = (OrganisationServiceImpl.OrganisationServiceLocalBinder)service;
            organisationServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    public void testCreateEntities() throws Exception {

        Organisation createEntity = OrganisationFactory.createOrganisationFactory(145525L);
        Organisation newEntity = organisationServiceImpl.saveOrganisation(createEntity);
        Assert.assertNotNull(TAG + " CREATE", newEntity);
    }
}

