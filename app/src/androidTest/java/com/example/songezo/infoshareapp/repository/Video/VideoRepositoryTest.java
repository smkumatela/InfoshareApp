package com.example.songezo.infoshareapp.repository.Video;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.Video;
import com.example.songezo.infoshareapp.repository.Video.Impl.VideoRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by VERNON on 2016/12/13.
 */
public class VideoRepositoryTest extends AndroidTestCase {

    private static final String TAG = "VIDEO TEST";
    private Long id;
    private String videoName;

    public void testCreateReadUpdateDelete() throws Exception {

        VideoRepository repository = new VideoRepositoryImpl(this.getContext());
        /**CREATE*/
        Video createEntity = new Video.Builder()
                .videoName("video")
                .build();
        Video insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<Video> videoSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", videoSet.size() > 0);

        //READ ENTITY
        Video entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        Video updateEntity = new Video.Builder()
                .copyObj(entity)
                .videoName("clip")
                .build();
        repository.update(updateEntity);
        Video newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "clip", newEntity.getVideoName());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        Video deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */
    }
}
