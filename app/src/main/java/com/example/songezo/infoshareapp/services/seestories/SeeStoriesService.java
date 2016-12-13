package com.example.songezo.infoshareapp.services.seestories;

import com.example.songezo.infoshareapp.domain.SeeStories;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public interface SeeStoriesService {

    SeeStories getSeeStoriesByID(Long id);


    SeeStories saveSeeStories(SeeStories entity);

    Set<SeeStories> findAll();
}
