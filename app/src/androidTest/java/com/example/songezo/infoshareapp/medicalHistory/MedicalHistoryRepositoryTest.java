package com.example.songezo.infoshareapp.medicalHistory;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.MedicalHistory;
import com.example.songezo.infoshareapp.repository.medicalHistory.Impl.MedicalHistoryRepositoryImpl;
import com.example.songezo.infoshareapp.repository.medicalHistory.MedicalHistoryRepository;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Songezo on 2016-12-13.
 */
public class MedicalHistoryRepositoryTest extends AndroidTestCase {

    private static final String TAG = "MEDICAL HISTORY TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        MedicalHistoryRepository repository = new MedicalHistoryRepositoryImpl(this.getContext());
    /*CREATE*/
        MedicalHistory createEntity = new MedicalHistory.Builder()
                .build();
        MedicalHistory insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        /*READ ALL*/
        Set<MedicalHistory> medicalHistorySet = repository.findAll();
        Assert.assertTrue(TAG + "READ ALL", medicalHistorySet.size() > 0);

        /*READ ENTITY*/
        MedicalHistory entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        /*UPDATE ENTITY*/
        MedicalHistory updateEntity = new MedicalHistory.Builder()
                                    .copyObj(entity)
                                    .build();
        repository.update(updateEntity);
        MedicalHistory newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Meddical History", newEntity.toString());


        /*DELETE ENTITY*/
        /*
        repository.delete(updateEntity);
        MedicalHistory deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + " DELETE", deletedEntity); */
    }



}