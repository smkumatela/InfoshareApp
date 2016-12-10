package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.Video;

/**
 * Created by VERNON on 2016/12/10.
 */
public class VideoFactory {

    Video video;

    private static VideoFactory videoFactory = null;

    public VideoFactory() {
    }

    public static VideoFactory getVideoFactory(){
        if (videoFactory == null){
            videoFactory = new VideoFactory();
        }
        return videoFactory;
    }

    public static Video createVideo(Long id){
        Video about1 = new Video.Builder()
                .id(7345L)
                .build();
        return about1;
    }

    @Override
    public String toString() {
        return "VideoFactory{" +
                "Video = " + video +
                '}';
    }
}
