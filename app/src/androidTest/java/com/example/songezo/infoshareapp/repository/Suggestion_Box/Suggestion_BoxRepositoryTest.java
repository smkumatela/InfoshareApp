package com.example.songezo.infoshareapp.repository.Suggestion_Box;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.Suggestion_Box;
import com.example.songezo.infoshareapp.repository.Suggestion_Box.Impl.Suggestion_BoxRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Mandisi on 12/14/2016.
 */

public class Suggestion_BoxRepositoryTest extends AndroidTestCase {

    private static final String TAG = "SUGGESTION_BOX TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        Suggestion_BoxRepository repository = new Suggestion_BoxRepositoryImpl(this.getContext());
        /**CREATE*/
        Suggestion_Box createEntity = new Suggestion_Box.Builder()
                .build();
        Suggestion_Box insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<Suggestion_Box> suggestion_BoxSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", suggestion_BoxSet.size() > 0);

        //READ ENTITY
        Suggestion_Box entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        Suggestion_Box updateEntity = new Suggestion_Box.Builder()
                .copyObj(entity)
                .build();
        repository.update(updateEntity);
        Suggestion_Box newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "My Suggestion_Box", newEntity.toString());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        Suggestion_Box deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */

    }

}
