package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.Event_Calender;

/**
 * Created by Mandisi on 12/13/2016.
 */

public class Event_CalenderFactory {
    Event_Calender event_Calender;

    private static Event_CalenderFactory event_CalenderFactory = null;

    public Event_CalenderFactory() {
    }

    public static Event_CalenderFactory getHistoryFactory(){
        if (event_CalenderFactory == null){
            event_CalenderFactory = new Event_CalenderFactory();
        }
        return event_CalenderFactory;
    }

    public static Event_Calender createEvent_CalenderFactory(String organization, Long id){
        Event_Calender event_Calender1 = new Event_Calender.Builder()
                .organization(organization)
                .id(id)
                .build();
        return event_Calender1;
    }

    @Override
    public String toString() {
        return "event_CalenderFactory{" +
                "event_Calender=" + event_Calender +
                '}';
    }
}

