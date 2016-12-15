package com.example.songezo.infoshareapp.repository.Caregiver;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.Caregiver;
import com.example.songezo.infoshareapp.repository.Caregiver.Impl.CaregiverRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Mandisi on 12/14/2016.
 */

public class CaregiverRepositoryTest extends AndroidTestCase {

    private static final String TAG = "CAREGIVER TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        CaregiverRepository repository = new CaregiverRepositoryImpl(this.getContext());
        /**CREATE*/
        Caregiver createEntity = new Caregiver.Builder()
                .build();
        Caregiver insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<Caregiver> caregiverSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", caregiverSet.size() > 0);

        //READ ENTITY
        Caregiver entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        Caregiver updateEntity = new Caregiver.Builder()
                .copyObj(entity)
                .build();
        repository.update(updateEntity);
        Caregiver newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "My Caregiver", newEntity.toString());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        Caregiver deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */

    }

}
