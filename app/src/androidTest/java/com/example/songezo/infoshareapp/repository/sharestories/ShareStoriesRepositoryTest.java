package com.example.songezo.infoshareapp.repository.sharestories;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.ShareStories;
import com.example.songezo.infoshareapp.repository.sharestories.Impl.ShareStoriesRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class ShareStoriesRepositoryTest extends AndroidTestCase {

    private static final String TAG = "SHARESTORIES TEST";
    private Long id;
    private String share;
    private String clear;


    public void testCreateReadUpdateDelete() throws Exception {

        ShareStoriesRepository repository = new ShareStoriesRepositoryImpl(this.getContext());
        /**CREATE*/
        ShareStories createEntity = new ShareStories.Builder()
                .share("Shared")
                .clear("Cleared")
                .build();
        ShareStories insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<ShareStories> shareStoriesSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", shareStoriesSet.size() > 0);

        //READ ENTITY
        ShareStories entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        ShareStories updateEntity = new ShareStories.Builder()
                .copyObj(entity)
                .share("Shared2")
                .build();
        repository.update(updateEntity);
        ShareStories newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Shared2", newEntity.getShare());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        ShareStories deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */

    }
}
