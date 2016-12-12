package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.MedicalHistory;

import java.util.Date;
import java.util.Map;

/**
 * Created by Songezo on 2016-12-10.
 */
public class MedicalHistoryFactory {
    MedicalHistory medicalHistory;

    private static MedicalHistoryFactory historyFactory = null;

    public MedicalHistoryFactory() {
    }

    public static MedicalHistoryFactory getHistoryFactory(){
        if (historyFactory == null){
            historyFactory = new MedicalHistoryFactory();
        }
        return historyFactory;
    }

    public static MedicalHistory createMedicalHistory(Map<String, String> values, Date date, Long id){
        MedicalHistory medicalHistory1 = new MedicalHistory.Builder()
                                .comments(values.get("comments about Medical History"))
                                .task(values.get("tasks to be done"))
                                .id(12345L)
                                .date(date)
                                .build();
        return medicalHistory1;
    }

    @Override
    public String toString() {
        return "MedicalHistoryFactory{" +
                "medicalHistory=" + medicalHistory +
                '}';
    }
}
