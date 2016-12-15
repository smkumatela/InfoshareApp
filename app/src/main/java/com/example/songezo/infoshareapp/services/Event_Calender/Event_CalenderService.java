package com.example.songezo.infoshareapp.services.Event_Calender;

import com.example.songezo.infoshareapp.domain.Event_Calender;

import java.util.Set;

/**
 * Created by Mandisi on 12/14/2016.
 */

public interface Event_CalenderService {
    Event_Calender getEvent_CalenderByID(Long id);


    Event_Calender saveEvent_Calender(Event_Calender entity);

    Set<Event_Calender> findAll();
}

