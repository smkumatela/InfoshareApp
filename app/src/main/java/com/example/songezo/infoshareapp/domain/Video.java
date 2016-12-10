package com.example.songezo.infoshareapp.domain;

/**
 * Created by VERNON on 2016/12/10.
 */
public class Video {

    private Long id;


    public Video(Builder builderObjt){
        id = builderObjt.id;

    }

    public Video( Long id){
        this.id = id;

    }


    public Long getId() {
        return id;
    }


    public static class Builder{
        private Long id;


        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copyObj(Video videoObj){
            this.id = videoObj.getId();
            return this;
        }

        public Video build(){
            return new Video(this);
        }
    }
}
