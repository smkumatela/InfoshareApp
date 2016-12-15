package com.example.songezo.infoshareapp.domain;

/**
 * Created by Mandisi on 12/9/2016.
 */

public class Suggestion_Box {
    private Long id;

    public Suggestion_Box(Builder builderObjt){
        id = builderObjt.id;
    }

    public Suggestion_Box(Long id){
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

        public Builder copyObj(Suggestion_Box suggestion_BoxObj){
            this.id = suggestion_BoxObj.getId();
            return this;
        }

        public Suggestion_Box build(){
            return new Suggestion_Box(this);
        }
    }

}