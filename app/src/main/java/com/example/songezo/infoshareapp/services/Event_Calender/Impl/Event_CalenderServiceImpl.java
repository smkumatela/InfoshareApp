package com.example.songezo.infoshareapp.services.Event_Calender.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Event_Calender;
import com.example.songezo.infoshareapp.repository.Event_Calender.Event_CalenderRepository;
import com.example.songezo.infoshareapp.repository.Event_Calender.Impl.Event_CalenderRepositoryImpl;
import com.example.songezo.infoshareapp.services.Event_Calender.Event_CalenderService;

import java.util.Set;

/**
 * Created by Mandisi on 12/14/2016.
 */

public class Event_CalenderServiceImpl extends Service implements Event_CalenderService {

    private Event_CalenderRepository repository;

    private final IBinder localBinder = new Event_CalenderserviceLocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    private static Event_CalenderServiceImpl service = null;

    public Event_CalenderServiceImpl() {

        repository = new Event_CalenderRepositoryImpl(App.getAppContext());
    }

    public static Event_CalenderServiceImpl getInstance() {
        if (service == null)
            service = new Event_CalenderServiceImpl();
        return service;
    }
    public class Event_CalenderserviceLocalBinder extends Binder {
        public Event_CalenderServiceImpl getService() {
            return Event_CalenderServiceImpl.this;
        }
    }

    @Override
    public Event_Calender getEvent_CalenderByID(Long id)
    {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    public Event_Calender saveEvent_Calender(Event_Calender entity)
    {
        return repository.save(entity);
    }

    public Set<Event_Calender> findAll()
    {
        return repository.findAll();
    }
}
