package com.example.songezo.infoshareapp.domain;

/**
 * Created by Mandisi on 12/9/2016.
 */

public class Weather {
    private Long id;

    public Weather(Builder builderObjt){
        id = builderObjt.id;
    }

    public Weather(Long id){
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

        public Builder copyObj(Weather weatherObj){
            this.id = weatherObj.getId();
            return this;
        }

        public Weather build(){
            return new Weather(this);
        }
    }

}