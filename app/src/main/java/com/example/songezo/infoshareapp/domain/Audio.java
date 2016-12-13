package com.example.songezo.infoshareapp.domain;

/**
 * Created by VERNON on 2016/12/10.
 */
public class Audio {

    private Long id;
    private String audioName;


    public Audio(Builder builderObjt){
        id = builderObjt.id;
        audioName = builderObjt.audioName;

    }

    public Audio( Long id, String audioName){
        this.id = id;
        this.audioName = audioName;

    }


    public Long getId() {
        return id;
    }

    public String getAudioName() {return audioName; }


    public static class Builder{
        private Long id;
        private String audioName;


        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder audioName(String audioName){
            this.audioName = audioName;
            return this;
        }

        public Builder copyObj(Audio audioObj){
            this.id = audioObj.getId();
            this.audioName = audioObj.getAudioName();
            return this;
        }

        public Audio build(){
            return new Audio(this);
        }
    }
}
