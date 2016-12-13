package com.example.songezo.infoshareapp.repository.About;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.About;
import com.example.songezo.infoshareapp.repository.About.Impl.AboutRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by VERNON on 2016/12/13.
 */
public class AboutRepositoryTest extends AndroidTestCase {

    private static final String TAG = "ABOUT TEST";
    private Long id;
    private String aboutInfoshare;

    public void testCreateReadUpdateDelete() throws Exception {

        AboutRepository repository = new AboutRepositoryImpl(this.getContext());
        /**CREATE*/
        About createEntity = new About.Builder()
                .aboutInfoshare("Infoshare Shares info")
                .build();
        About insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<About> aboutSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", aboutSet.size() > 0);

        //READ ENTITY
        About entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        About updateEntity = new About.Builder()
                .copyObj(entity)
                .aboutInfoshare("Infoshare")
                .build();
        repository.update(updateEntity);
        About newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "About ", newEntity.getAboutInfoshare());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        About deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */
    }
}
