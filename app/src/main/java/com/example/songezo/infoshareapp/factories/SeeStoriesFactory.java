package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.SeeStories;
import com.example.songezo.infoshareapp.domain.ShareStories;

/**
 * Created by asiphe.dyani on 2016/12/10.
 */

public class SeeStoriesFactory {

    SeeStories seeStories;

    private static SeeStoriesFactory seeStoriesFactory = null;

    public SeeStoriesFactory() {
    }

    public static SeeStoriesFactory getHistoryFactory(){
        if (seeStoriesFactory == null){
            seeStoriesFactory = new SeeStoriesFactory();
        }
        return seeStoriesFactory;
    }

    public static SeeStories createSeeStoriesFactory(String shareStories, Long id){
        SeeStories seeStories1 = new SeeStories.Builder()
                .stories(shareStories)
                .id(id)
                .build();
        return seeStories1;
    }

    @Override
    public String toString() {
        return "seeStoriesFactory{" +
                "seeStories=" + seeStories +
                '}';
    }
}
