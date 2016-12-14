package com.example.songezo.infoshareapp.services.Articles;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.SystemClock;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.Articles;
import com.example.songezo.infoshareapp.factories.ArticlesFactory;
import com.example.songezo.infoshareapp.services.Articles.Impl.ArticlesServiceImpl;

import junit.framework.Assert;

import java.util.Date;

/**
 * Created by VERNON on 2016/12/14.
 */
public class ArticlesServiceTest extends AndroidTestCase {

    Date date;

    private ArticlesServiceImpl articlesServiceImpl;
    private boolean isBound;
    private static final String TAG="ARTICLES TEST";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), ArticlesServiceImpl.class);
        App.context = this.getContext();
        articlesServiceImpl = ArticlesServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ArticlesServiceImpl.ArticlesServiceLocalBinder binder
                    = (ArticlesServiceImpl.ArticlesServiceLocalBinder)service;
            articlesServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    public void testCreateEntities() throws Exception {

        Articles createEntity = ArticlesFactory.createArticle("Cat","top", date, 32225L);
        Articles newEntity = articlesServiceImpl.saveArticles(createEntity);
        Assert.assertNotNull(TAG + " CREATE", newEntity);
    }
}
