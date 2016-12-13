package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.MedicalHistory;
import com.example.songezo.infoshareapp.domain.Patient;
import com.example.songezo.infoshareapp.domain.ToDo;

import java.util.Date;
import java.util.Map;

/**
 * Created by Songezo on 2016-12-10.
 */
public class PatientFactory {

    Patient patient;

    private static PatientFactory patients = null;

    public PatientFactory() {
    }

    public static PatientFactory getPatientInstance(){
        if (patients == null){
            patients = new PatientFactory();
        }
        return patients;
    }

    public static Patient createPatient(Map<String, String> values, Date dateOfBirth, boolean gender, String toDo, String medicalHistory){
        Patient patient1 = new Patient.Builder()
                            .address(values.get("residential address"))
                            .language(values.get("home Language"))
                            .name(values.get("first name"))
                            .reasonForVisit(values.get("reason"))
                            .date(dateOfBirth)
                            .telephone(021-7658-897)
                            .medicalHistory(medicalHistory)
                            .toDo(toDo)
                            .id(246810L)
                            .build();
        return patient1;
    }

    @Override
    public String toString() {
        return "PatientFactory{" +
                "patient=" + patient +
                '}';
    }
}
