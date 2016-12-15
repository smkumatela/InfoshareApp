package com.example.songezo.infoshareapp.services.Caregiver;

import com.example.songezo.infoshareapp.domain.Caregiver;

import java.util.Set;

/**
 * Created by Mandisi on 12/14/2016.
 */

public interface  CaregiverService {

    Caregiver getCaregiverByID(Long id);


    Caregiver saveCaregiver(Caregiver entity);

    Set<Caregiver> findAll();
}

