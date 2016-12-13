package com.example.songezo.infoshareapp.patient;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.Patient;
import com.example.songezo.infoshareapp.repository.patient.Impl.PatientRepositoryImpl;
import com.example.songezo.infoshareapp.repository.patient.PatientRepository;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Songezo on 2016-12-13.
 */
public class PatientRepositoryTest extends AndroidTestCase {

    private static final String TAG = "PATIENT TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        PatientRepository repository = new PatientRepositoryImpl(this.getContext());
        /*CREATE*/
        Patient createEntity = new Patient.Builder()
                                .build();
        Patient insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        /*READ ALL*/
        Set<Patient> patientSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", patientSet.size() > 0);

        /*READ ENTITY*/
        Patient entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        /*UPDATE ENTITY*/
        Patient updateEntity = new Patient.Builder()
                            .copyObj(entity)
                            .build();
        repository.update(updateEntity);
        Patient newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Patient", newEntity.toString());

        /*DELETE ENTITY*/
        /*
        repository.delete(updateEntity);
        Patient deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */
    }
}
