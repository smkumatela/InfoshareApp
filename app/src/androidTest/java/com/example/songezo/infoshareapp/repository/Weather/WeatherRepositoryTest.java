package com.example.songezo.infoshareapp.repository.Weather;

import junit.framework.Assert;

import java.util.Set;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.Weather;
import com.example.songezo.infoshareapp.repository.Weather.Impl.WeatherRepositoryImpl;

/**
 * Created by Mandisi on 12/14/2016.
 */

public class WeatherRepositoryTest extends AndroidTestCase {

    private static final String TAG = "WEATHER TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        WeatherRepository repository = new WeatherRepositoryImpl(this.getContext());
        /**CREATE*/
        Weather createEntity = new Weather.Builder()
                .build();
        Weather insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<Weather> weatherSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", weatherSet.size() > 0);

        //READ ENTITY
        Weather entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        Weather updateEntity = new Weather.Builder()
                .copyObj(entity)
                .build();
        repository.update(updateEntity);
        Weather newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "My Weather", newEntity.toString());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        Weather deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */

    }

}
