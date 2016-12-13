package com.example.songezo.infoshareapp.repository.Articles;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.Articles;
import com.example.songezo.infoshareapp.repository.Articles.Impl.ArticlesRepositoryImpl;

import junit.framework.Assert;

import java.util.Date;
import java.util.Set;

/**
 * Created by VERNON on 2016/12/13.
 */
public class ArticlesRepositoryTest extends AndroidTestCase {

    private static final String TAG = "ARTICLES TEST";
    private Long id;
    private String name;
    private Date date;
    private String topic;
    private String category;

    public void testCreateReadUpdateDelete() throws Exception {

        ArticlesRepository repository = new ArticlesRepositoryImpl(this.getContext());
        /**CREATE*/
        Articles createEntity = new Articles.Builder()
                .name("Vernon")
                .date(date)
                .topic("information")
                .category("info")
                .build();
        Articles insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<Articles> articlesSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", articlesSet.size() > 0);

        //READ ENTITY
        Articles entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        Articles updateEntity = new Articles.Builder()
                .copyObj(entity)
                .name("Swartland")
                .build();
        repository.update(updateEntity);
        Articles newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "About ", newEntity.getName());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        Articles deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */
    }
}
