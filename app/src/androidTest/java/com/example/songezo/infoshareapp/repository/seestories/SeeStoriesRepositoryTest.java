package com.example.songezo.infoshareapp.repository.seestories;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.SeeStories;
import com.example.songezo.infoshareapp.repository.seestories.Impl.SeeStoriesRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class SeeStoriesRepositoryTest extends AndroidTestCase {

    private static final String TAG = "SEESTORIES TEST";
    private Long id;
    private String stories;

    public void testCreateReadUpdateDelete() throws Exception {

        SeeStoriesRepository repository = new SeeStoriesRepositoryImpl(this.getContext());
        /**CREATE*/
        SeeStories createEntity = new SeeStories.Builder()
                .stories("My Story")
                .build();
        SeeStories insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<SeeStories> seeStoriesSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", seeStoriesSet.size() > 0);

        //READ ENTITY
        SeeStories entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        SeeStories updateEntity = new SeeStories.Builder()
                .copyObj(entity)
                .stories("MyStory2")
                .build();
        repository.update(updateEntity);
        SeeStories newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "MyStory2", newEntity.getStories());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        ShareStories deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */

    }
}
