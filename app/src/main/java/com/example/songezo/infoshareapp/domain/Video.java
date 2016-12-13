package com.example.songezo.infoshareapp.domain;

/**
 * Created by VERNON on 2016/12/10.
 */
public class Video {

    private Long id;
    private String videoName;


    public Video(Builder builderObjt){
        id = builderObjt.id;
        videoName =builderObjt.videoName;

    }

    public Video( Long id, String videoName){
        this.id = id;
        this.videoName = videoName;

    }


    public Long getId() {
        return id;
    }

    public String getVideoName() { return videoName;}


    public static class Builder{
        private Long id;
        private String videoName;


        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder videoName(String videoName){
            this.videoName = videoName;
            return this;
        }

        public Builder copyObj(Video videoObj){
            this.id = videoObj.getId();
            this.videoName = videoObj.getVideoName();
            return this;
        }

        public Video build(){
            return new Video(this);
        }
    }
}
