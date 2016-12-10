package com.example.songezo.infoshareapp.domain;

/**
 * Created by VERNON on 2016/12/10.
 */
public class Audio {

    private Long id;


    public Audio(Builder builderObjt){
        id = builderObjt.id;

    }

    public Audio( Long id){
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

        public Builder copyObj(Audio audioObj){
            this.id = audioObj.getId();
            return this;
        }

        public Audio build(){
            return new Audio(this);
        }
    }
}
