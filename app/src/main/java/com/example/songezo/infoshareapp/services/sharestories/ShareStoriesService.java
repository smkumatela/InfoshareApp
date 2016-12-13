package com.example.songezo.infoshareapp.services.sharestories;

import com.example.songezo.infoshareapp.domain.ShareStories;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public interface ShareStoriesService {

    ShareStories getShareStoriesByID(Long id);


    ShareStories saveShareStories(ShareStories entity);

    Set<ShareStories> findAll();
}
