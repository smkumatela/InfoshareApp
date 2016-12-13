package com.example.songezo.infoshareapp.services.medicalHistory;

import com.example.songezo.infoshareapp.domain.MedicalHistory;

import java.util.Set;

/**
 * Created by Songezo on 2016-12-13.
 */
public interface MedicalHistoryService {

    MedicalHistory getMedicalHistoryByID(Long id);

    MedicalHistory saveMedicalHistory(MedicalHistory entity);

    Set<MedicalHistory> findAll();
}
