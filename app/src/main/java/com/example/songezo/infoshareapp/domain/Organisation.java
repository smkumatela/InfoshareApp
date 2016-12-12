package com.example.songezo.infoshareapp.domain;

/**
 * Created by asiphe.dyani on 2016/12/09.
 */

public class Organisation {
    private Long id;

    public Organisation(Builder builderObjt){
        id = builderObjt.id;
    }

    public Organisation(Long id){
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

        public Builder copyObj(Organisation organisationObj){
            this.id = organisationObj.getId();
            return this;
        }

        public Organisation build(){
            return new Organisation(this);
        }
    }

}
