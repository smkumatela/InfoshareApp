package com.example.songezo.infoshareapp.repository.login;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.Login;
import com.example.songezo.infoshareapp.repository.login.Impl.LoginRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class LoginRepositoryTest extends AndroidTestCase {

    private static final String TAG = "LOGIN TEST";
    private Long id;
    private String username;
    private String password;

    public void testCreateReadUpdateDelete() throws Exception {

        LoginRepository repository = new LoginRepositoryImpl(this.getContext());
        /**CREATE*/
        Login createEntity = new Login.Builder()
                .username("Lokal Ash")
                .password("badpassowrd123")
                .build();
        Login insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<Login> loginSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", loginSet.size() > 0);

        //READ ENTITY
        Login entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        Login updateEntity = new Login.Builder()
                .copyObj(entity)
                .username("Ash.com")
                .build();
        repository.update(updateEntity);
        Login newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Ash.com", newEntity.getUsername());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        Login deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */

    }

}


