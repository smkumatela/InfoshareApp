package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.Caregiver;

/**
 * Created by Mandisi on 12/13/2016.
 */

public class CaregiverFactory {
    Caregiver caregiver;

    private static CaregiverFactory caregiverFactory = null;

    public CaregiverFactory() {
    }

    public static CaregiverFactory getLogFactory(){
        if (caregiverFactory == null){
            caregiverFactory = new CaregiverFactory();
        }
        return caregiverFactory;
    }

    public static Caregiver createCaregiverFactory(Long id){
        Caregiver caregiver1 = new Caregiver.Builder()
                .id(id)
                .build();

        return caregiver1;
    }

    @Override
    public String toString() {
        return "caregiverFactory{" +
                "caregiver=" + caregiver +
                '}';
    }
}

