package com.example.songezo.infoshareapp.repository.Extras;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.Extras;
import com.example.songezo.infoshareapp.repository.Extras.Impl.ExtrasRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Mandisi on 12/14/2016.
 */

public class ExtrasRepositoryTest extends AndroidTestCase {

    private static final String TAG = "EXTRAS TEST";
    private Long id;
    private String event_Calender;
    private String weather;
    private String messagingContacts;
    private String seeStories;
    private String about;

    public void testCreateReadUpdateDelete() throws Exception {

        ExtrasRepository repository = new ExtrasRepositoryImpl(this.getContext());
        /**CREATE*/
        Extras createEntity = new Extras.Builder()
                .event_Calender("Summertimes")
                .weather("cold")
                .suggestion_Box("Need more users")
                .audioVisuals("dre")
                .about("My extras")
                .build();
        Extras insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<Extras> extrasSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", extrasSet.size() > 0);

        //READ ENTITY
        Extras entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        Extras updateEntity = new Extras.Builder()
                .copyObj(entity)
                .event_Calender("rainy")
                .build();
        repository.update(updateEntity);
        Extras newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "rainy", newEntity.getEvent_Calender());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        Extras deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */

    }
}
