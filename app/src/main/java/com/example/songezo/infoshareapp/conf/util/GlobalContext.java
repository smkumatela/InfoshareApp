package com.example.songezo.infoshareapp.conf.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by Songezo on 2016-05-28.
 */
public class GlobalContext extends Application {

    public static Context context;

    private static GlobalContext singleton;

    public void onCreate() {
        super.onCreate();
        GlobalContext.context = getApplicationContext();
        singleton = this;
    }

    public static Context getAppContext() {
        return GlobalContext.context;
    }

    public static synchronized GlobalContext getInstance() {
        return singleton;
    }

}
