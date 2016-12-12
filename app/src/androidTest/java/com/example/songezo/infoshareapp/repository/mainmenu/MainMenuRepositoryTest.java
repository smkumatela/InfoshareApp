package com.example.songezo.infoshareapp.repository.mainmenu;

import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.domain.MainMenu;
import com.example.songezo.infoshareapp.repository.mainmenu.Impl.MainMenuRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public class MainMenuRepositoryTest extends AndroidTestCase {

    private static final String TAG = "MAINMENU TEST";
    private Long id;
    private String myPatient;
    private String stories;
    private String messagingContacts;
    private String seeStories;
    private String extras;

    public void testCreateReadUpdateDelete() throws Exception {

        MainMenuRepository repository = new MainMenuRepositoryImpl(this.getContext());
        /**CREATE*/
        MainMenu createEntity = new MainMenu.Builder()
                .myPatient("Cathy")
                .stories("Story20")
                .messagingContacts("My Msg Conts")
                .seeStories("Stories Seen")
                .extras("My extras")
                .build();
        MainMenu insertedEntity = repository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "  CREATE", insertedEntity);

        // READ ALL
        Set<MainMenu> mainMenuSet = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", mainMenuSet.size() > 0);

        //READ ENTITY
        MainMenu entity = repository.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE ENTITY
        MainMenu updateEntity = new MainMenu.Builder()
                .copyObj(entity)
                .myPatient("Jonny")
                .build();
        repository.update(updateEntity);
        MainMenu newEntity = repository.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Jonny", newEntity.getMyPatient());


        /*
        //**DELETE ENTITY
        repository.delete(updateEntity);
        MainMenu deletedEntity = repository.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity); */

    }
}
