package com.example.songezo.infoshareapp.services.messagingcontacts;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.MessagingContacts;
import com.example.songezo.infoshareapp.factories.MessagingContactsFactory;
import com.example.songezo.infoshareapp.services.messagingcontacts.Impl.MessagingContactsServiceImpl;

import junit.framework.Assert;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class MessagingContactsServiceTest extends AndroidTestCase {

    private MessagingContactsServiceImpl messagingContactsServiceImpl;
    private boolean isBound;
    private static final String TAG="MESSAGINGCONTACTS TEST";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), MessagingContactsServiceImpl.class);
        App.context = this.getContext();
        messagingContactsServiceImpl = MessagingContactsServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MessagingContactsServiceImpl.MessagingContactsServiceLocalBinder binder
                    = (MessagingContactsServiceImpl.MessagingContactsServiceLocalBinder)service;
            messagingContactsServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    public void testCreateEntities() throws Exception {

        MessagingContacts createEntity = MessagingContactsFactory.createMessagingContactsFactory("Ash","Wasup Inc", 14425L);
        MessagingContacts newEntity = messagingContactsServiceImpl.saveMainMenu(createEntity);
        Assert.assertNotNull(TAG + " CREATE", newEntity);
    }
}
