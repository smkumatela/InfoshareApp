package com.example.songezo.infoshareapp.services.patient;

import com.example.songezo.infoshareapp.domain.Patient;

import java.util.Set;

/**
 * Created by Songezo on 2016-12-13.
 */
public interface PatientService {

    Patient getPatientByID(Long id);

    Patient savePatient(Patient entity);

    Set<Patient> findAll();
}
