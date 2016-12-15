package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.Extras;

/**
 * Created by Mandisi on 12/13/2016.
 */

public class ExtrasFactory {
    Extras extras;

    private static ExtrasFactory extrasFactory = null;

    public ExtrasFactory() {
    }

    public static ExtrasFactory getExtrasFactory(){
        if (extrasFactory == null){
            extrasFactory = new ExtrasFactory();
        }
        return extrasFactory;
    }

    public static Extras createExtrasFactory(String event_Calender, String weather, String suggestion_Box, String audioVisuals, String about, Long id){
        Extras extras1 = new Extras.Builder()
                .event_Calender(event_Calender)
                .weather(weather)
                .suggestion_Box(suggestion_Box)
                .audioVisuals(audioVisuals)
                .about(about)
                .id(id)
                .build();
        return extras1;
    }

    @Override
    public String toString() {
        return "ExtrasFactory{" +
                "extras=" + extras +
                '}';
    }

}

