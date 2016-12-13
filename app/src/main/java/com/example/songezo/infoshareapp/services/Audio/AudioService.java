package com.example.songezo.infoshareapp.services.Audio;

import com.example.songezo.infoshareapp.domain.Audio;

import java.util.Set;

/**
 * Created by VERNON on 2016/12/13.
 */
public interface AudioService {

    Audio getAudioByID(Long id);


    Audio saveAudio(Audio entity);

    Set<Audio> findAll();
}
