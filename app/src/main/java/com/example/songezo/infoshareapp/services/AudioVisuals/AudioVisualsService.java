package com.example.songezo.infoshareapp.services.AudioVisuals;

import com.example.songezo.infoshareapp.domain.AudioVisuals;

import java.util.Set;

/**
 * Created by VERNON on 2016/12/13.
 */
public interface AudioVisualsService {

    AudioVisuals getAudioVisualsByID(Long id);


    AudioVisuals saveAudioVisuals(AudioVisuals entity);

    Set<AudioVisuals> findAll();
}
