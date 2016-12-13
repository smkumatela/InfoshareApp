package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.ShareStories;

/**
 * Created by asiphe.dyani on 2016/12/10.
 */

public class ShareStoriesFactory {

    ShareStories shareStories;

    private static ShareStoriesFactory shareStoriesFactory = null;

    public ShareStoriesFactory() {
    }

    public static ShareStoriesFactory getShareStoriesFactory(){
        if (shareStoriesFactory == null){
            shareStoriesFactory = new ShareStoriesFactory();
        }
        return shareStoriesFactory;
    }

    public static ShareStories createShareStoriesFactory(String clear, String share, Long id){
        ShareStories shareStories1 = new ShareStories.Builder()
                .clear(clear)
                .share(share)
                .id(id)
                .build();
        return shareStories1;
    }

    @Override
    public String toString() {
        return "ShareStoriesFactory{" +
                "shareHistory=" + shareStoriesFactory +
                '}';
    }

}
