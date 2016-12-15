package com.example.songezo.infoshareapp.services.Suggestion_Box;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Suggestion_Box;
import com.example.songezo.infoshareapp.factories.Suggestion_BoxFactory;
import com.example.songezo.infoshareapp.services.Suggestion_Box.Impl.Suggestion_BoxServiceImpl;

import junit.framework.Assert;

/**
 * Created by Mandisi on 12/14/2016.
 */

public class Suggestion_BoxServiceTest extends AndroidTestCase {

    private Suggestion_BoxServiceImpl suggestion_BoxServiceImpl;
    private boolean isBound;
    private static final String TAG="SUGGESTION_BOX TEST";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), Suggestion_BoxServiceImpl.class);
        App.context = this.getContext();
        suggestion_BoxServiceImpl = Suggestion_BoxServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Suggestion_BoxServiceImpl.OrganisationServiceLocalBinder binder
                    = (Suggestion_BoxServiceImpl.OrganisationServiceLocalBinder)service;
            suggestion_BoxServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    public void testCreateEntities() throws Exception {

        Suggestion_Box createEntity = Suggestion_BoxFactory.createSuggestion_BoxFactory(789654L);
        Suggestion_Box newEntity = suggestion_BoxServiceImpl.saveSuggestion_Box(createEntity);
        Assert.assertNotNull(TAG + " CREATE", newEntity);
    }
}

