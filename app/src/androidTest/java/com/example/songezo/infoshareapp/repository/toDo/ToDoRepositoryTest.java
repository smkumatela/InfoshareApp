package com.example.songezo.infoshareapp.repository.toDo;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.ToDo;
import com.example.songezo.infoshareapp.repository.toDo.Impl.ToDoRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Songezo on 2016-12-13.
 */
public class ToDoRepositoryTest extends AndroidTestCase {

    private static final String TAG = "TODO TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        ToDoRepository repository = new ToDoRepositoryImpl(this.getContext());
    /*CREATE*/
        ToDo createEntity = new ToDo.Builder()
                .build();
        ToDo insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ENTITY", insertedEntity);


        /*READ ALL*/
        Set<ToDo> toDoSet = repository.findAll();
        Assert.assertTrue(TAG + " REAR ALL", toDoSet.size() > 0);

        /*READ ENTITY*/
        ToDo entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        /*UPDATE ENTITY*/
        ToDo updateEntity = new ToDo.Builder()
                            .copyObj(entity)
                            .build();
        repository.update(updateEntity);
        ToDo newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "TO DO LIST", newEntity.toString());

        /*DELETE*/
        /*
        repository.delete(updateEntity);
        ToDo deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + " DELETE", deletedEntity);*/
    }



}
