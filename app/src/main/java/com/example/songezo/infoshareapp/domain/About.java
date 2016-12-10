package com.example.songezo.infoshareapp.domain;

/**
 * Created by VERNON on 2016/12/10.
 */
public class About {

    private Long id;


    public About(Builder builderObjt){
        id = builderObjt.id;

    }

    public About( Long id){
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

        public Builder copyObj(About aboutObj){
            this.id = aboutObj.getId();
            return this;
        }

        public About build(){
            return new About(this);
        }
    }
}
