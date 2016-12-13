package com.example.songezo.infoshareapp.repository.AudioVisuals;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.AudioVisuals;
import com.example.songezo.infoshareapp.repository.AudioVisuals.Impl.AudioVisualsImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by VERNON on 2016/12/13.
 */
public class AudioVisualsRepositoryTest extends AndroidTestCase {

    private static final String TAG = "AUDIOVISUALS TEST";
    private Long id;
    private String aud;
    private String vid;

    public void testCreateReadUpdateDelete() throws Exception {

        AudioVisualsRepository repository = new AudioVisualsImpl(this.getContext());
        /**CREATE*/
        AudioVisuals createEntity = new AudioVisuals.Builder()
                .aud("audio")
                .vid("video")
                .build();
        AudioVisuals insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<AudioVisuals> audioVisualsSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", audioVisualsSet.size() > 0);

        //READ ENTITY
        AudioVisuals entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        AudioVisuals updateEntity = new AudioVisuals.Builder()
                .copyObj(entity)
                .vid("aud and vid")
                .build();
        repository.update(updateEntity);
        AudioVisuals newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "About ", newEntity.getVideo());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        Audio deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */
    }
}
