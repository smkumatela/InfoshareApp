package com.example.songezo.infoshareapp.repository.organisation;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.Organisation;
import com.example.songezo.infoshareapp.repository.organisation.Impl.OrganisationRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class OrganisationRepositoryTest extends AndroidTestCase {

    private static final String TAG = "ORGANISATION TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        OrganisationRepository repository = new OrganisationRepositoryImpl(this.getContext());
        /**CREATE*/
        Organisation createEntity = new Organisation.Builder()
                .build();
        Organisation insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<Organisation> organisationSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", organisationSet.size() > 0);

        //READ ENTITY
        Organisation entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        Organisation updateEntity = new Organisation.Builder()
                .copyObj(entity)
                .build();
        repository.update(updateEntity);
        Organisation newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "My Org", newEntity.toString());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        Organisation deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */

    }

}
