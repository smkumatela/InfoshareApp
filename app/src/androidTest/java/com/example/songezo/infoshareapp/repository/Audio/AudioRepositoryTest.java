package com.example.songezo.infoshareapp.repository.Audio;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.Audio;
import com.example.songezo.infoshareapp.repository.Audio.Impl.AudioRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by VERNON on 2016/12/13.
 */
public class AudioRepositoryTest extends AndroidTestCase {

    private static final String TAG = "AUDIO TEST";
    private Long id;
    private String audioName;

    public void testCreateReadUpdateDelete() throws Exception {

        AudioRepository repository = new AudioRepositoryImpl(this.getContext());
        /**CREATE*/
        Audio createEntity = new Audio.Builder()
                .audioName("track")
                .build();
        Audio insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<Audio> audioSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", audioSet.size() > 0);

        //READ ENTITY
        Audio entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        Audio updateEntity = new Audio.Builder()
                .copyObj(entity)
                .audioName("song")
                .build();
        repository.update(updateEntity);
        Audio newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "song", newEntity.getAudioName());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        Audio deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */
    }
}
