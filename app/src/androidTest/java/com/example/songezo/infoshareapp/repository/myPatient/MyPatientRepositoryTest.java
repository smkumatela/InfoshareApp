package com.example.songezo.infoshareapp.repository.myPatient;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.MyPatient;
import com.example.songezo.infoshareapp.repository.myPatient.Impl.MyPatientRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Songezo on 2016-12-13.
 */
public class MyPatientRepositoryTest extends AndroidTestCase {

    private static final String TAG = "MY PATIENT TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        MyPatientRepository repository =  new MyPatientRepositoryImpl(this.getContext());
        /*CREATE*/
        MyPatient createEntity = new MyPatient.Builder()
                                .build();
        MyPatient insetedEntity = repository.save(createEntity);
        id = insetedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insetedEntity);

        /*READ ALL*/
        Set<MyPatient> myPatientSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", myPatientSet.size() > 0);

        /*READ ENTITY*/
        MyPatient entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        /*UPDATE ENTITY*/
        MyPatient updateEntity = new MyPatient.Builder()
                                .copyObj(entity)
                                .build();
        repository.update(updateEntity);
        MyPatient newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "MY PATIENT", newEntity.toString());

        /*DELETE*/
        /*
        repository.delete(updateEntity);
        MyPatient deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + " DELETE", deletedEntity);*/

    }
}
