package com.example.songezo.infoshareapp.repository.Event_Calender;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.Event_Calender;
import com.example.songezo.infoshareapp.repository.Event_Calender.Impl.Event_CalenderRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Mandisi on 12/14/2016.
 */

public class Event_CalenderRepositoryTest extends AndroidTestCase {

    private static final String TAG = "EVENT_CALANDER TEST";
    private Long id;
    private String stories;

    public void testCreateReadUpdateDelete() throws Exception {

        Event_CalenderRepository repository = new Event_CalenderRepositoryImpl(this.getContext());
        /**CREATE*/
        Event_Calender createEntity = new Event_Calender.Builder()
                .organization("My Organization")
                .build();
        Event_Calender insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<Event_Calender> event_CalenderSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", event_CalenderSet.size() > 0);

        //READ ENTITY
        Event_Calender entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        Event_Calender updateEntity = new Event_Calender.Builder()
                .copyObj(entity)
                .organization("My org")
                .build();
        repository.update(updateEntity);
        Event_Calender newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "My org", newEntity.getOrganization());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        Event_Calender deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */

    }
}
