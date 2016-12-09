package com.example.songezo.infoshareapp.domain;

/**
 * Created by asiphe.dyani on 2016/12/09.
 */

public class SeeStories {
    private Long id;
    private ShareStories stories;

    public SeeStories(Builder builderObjt){
        id = builderObjt.id;
        stories = builderObjt.stories;
    }

    public SeeStories(ShareStories stories, Long id){
        this.id = id;
        this.stories = stories;
    }

    public ShareStories getStories() {
        return stories;
    }

    public Long getId() {
        return id;
    }


    public static class Builder{
        private Long id;
        private ShareStories stories;

        public Builder stories(ShareStories stories){
            this.stories = stories;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copyObj(SeeStories seeStoriesObj){
            this.id = seeStoriesObj.getId();
            this.stories = seeStoriesObj.getStories();
            return this;
        }

        public SeeStories build(){
            return new SeeStories(this);
        }
    }
}
