package com.example.songezo.infoshareapp.repository.messagingcontacts;

import android.test.AndroidTestCase;


import com.example.songezo.infoshareapp.domain.MessagingContacts;
import com.example.songezo.infoshareapp.repository.messagingcontacts.Impl.MessagingContactsRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class MessagingContactsRepositoryTest extends AndroidTestCase {

    private static final String TAG = "MESSAGINNGCONTACTS TEST";
    private Long id;
    private String caregiver;
    private String organisation;

    public void testCreateReadUpdateDelete() throws Exception {

        MessagingContactsRepository repository = new MessagingContactsRepositoryImpl(this.getContext());
        /**CREATE*/
        MessagingContacts createEntity = new MessagingContacts.Builder()
                .caregiver("Ash")
                .organisation("Health INC")
                .build();
        MessagingContacts insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<MessagingContacts> seeStoriesSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", seeStoriesSet.size() > 0);

        //READ ENTITY
        MessagingContacts entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        MessagingContacts updateEntity = new MessagingContacts.Builder()
                .copyObj(entity)
                .caregiver("John Doe")
                .build();
        repository.update(updateEntity);
        MessagingContacts newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "John Doe", newEntity.getCaregiver());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        MessagingContacts deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */

    }
}
