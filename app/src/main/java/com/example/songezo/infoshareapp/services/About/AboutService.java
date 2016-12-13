package com.example.songezo.infoshareapp.services.About;

import com.example.songezo.infoshareapp.domain.About;

import java.util.Set;

/**
 * Created by VERNON on 2016/12/13.
 */
public interface AboutService {

    About getAboutByID(Long id);


    About saveAbout(About entity);

    Set<About> findAll();
}
