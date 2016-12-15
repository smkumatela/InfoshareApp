package com.example.songezo.infoshareapp.domain;

/**
 * Created by Mandisi on 12/9/2016.
 */

public class Caregiver {
    private Long id;

    public Caregiver(Builder builderObjt){
        id = builderObjt.id;
    }

    public Caregiver(Long id){
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

        public Builder copyObj(Caregiver caregiverObj){
            this.id = caregiverObj.getId();
            return this;
        }

        public Caregiver build(){
            return new Caregiver(this);
        }
    }

}
