package com.example.songezo.infoshareapp.services.messagingcontacts.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.MessagingContacts;
import com.example.songezo.infoshareapp.repository.messagingcontacts.Impl.MessagingContactsRepositoryImpl;
import com.example.songezo.infoshareapp.repository.messagingcontacts.MessagingContactsRepository;
import com.example.songezo.infoshareapp.services.messagingcontacts.MessagingContactsService;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class MessagingContactsServiceImpl extends Service implements MessagingContactsService {


    private MessagingContactsRepository repository;

    private final IBinder localBinder = new MessagingContactsServiceLocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    private static MessagingContactsServiceImpl service = null;

    public MessagingContactsServiceImpl() {

        repository = new MessagingContactsRepositoryImpl(App.getAppContext());
    }

    public static MessagingContactsServiceImpl getInstance() {
        if (service == null)
            service = new MessagingContactsServiceImpl();
        return service;
    }
    public class MessagingContactsServiceLocalBinder extends Binder {
        public MessagingContactsServiceImpl getService() {
            return MessagingContactsServiceImpl.this;
        }
    }

    @Override
    public MessagingContacts getMessagingContactsByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public MessagingContacts saveMainMenu(MessagingContacts entity)
    {
        return repository.save(entity);
    }

    public Set<MessagingContacts> findAll()
    {
        return repository.findAll();
    }
}
