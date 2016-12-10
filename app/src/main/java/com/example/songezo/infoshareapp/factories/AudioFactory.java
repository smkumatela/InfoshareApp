package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.Audio;

/**
 * Created by VERNON on 2016/12/10.
 */
public class AudioFactory {

    Audio audio;

    private static AudioFactory audioFactory = null;

    public AudioFactory() {
    }

    public static AudioFactory getAudioFactory(){
        if (audioFactory == null){
            audioFactory = new AudioFactory();
        }
        return audioFactory;
    }

    public static Audio createAudio(Long id){
        Audio about1 = new Audio.Builder()
                .id(4345L)
                .build();
        return about1;
    }

    @Override
    public String toString() {
        return "AudioFactory{" +
                "Audio = " + audio +
                '}';
    }
}
