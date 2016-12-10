package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.Audio;
import com.example.songezo.infoshareapp.domain.AudioVisuals;
import com.example.songezo.infoshareapp.domain.Video;

import java.util.Map;

/**
 * Created by VERNON on 2016/12/10.
 */
public class AudioVisualFactory {

    AudioVisuals audioVisuals;

    private static AudioVisualFactory audioVisualFactory = null;

    public AudioVisualFactory() {
    }

    public static AudioVisualFactory getAudioVisualFactory(){
        if (audioVisualFactory == null){
            audioVisualFactory = new AudioVisualFactory();
        }
        return audioVisualFactory;
    }

    public static AudioVisuals createAudioVisuals(Long id, Audio audio,Video video){
        AudioVisuals audioVisuals1 = new AudioVisuals.Builder()
                .aud(audio)
                .vid(video)
                .id(3345L)
                .build();
        return audioVisuals1;
    }

    @Override
    public String toString() {
        return "AudioVisualsFactory{" +
                "AudioVisuals = " + audioVisuals +
                '}';
    }
}
