package com.example.songezo.infoshareapp.services.Video;

import com.example.songezo.infoshareapp.domain.Video;

import java.util.Set;

/**
 * Created by VERNON on 2016/12/13.
 */
public interface VideoService {

    Video getVideoByID(Long id);


    Video saveVideo(Video entity);

    Set<Video> findAll();
}
