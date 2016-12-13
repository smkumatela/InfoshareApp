package com.example.songezo.infoshareapp.services.myPatient;

import com.example.songezo.infoshareapp.domain.MyPatient;

import java.util.Set;

/**
 * Created by Songezo on 2016-12-13.
 */
public interface MyPatientService {

    MyPatient getMyPatientByID(Long id);

    MyPatient saveMyPatient(MyPatient entity);

    Set<MyPatient> findAll();
}
