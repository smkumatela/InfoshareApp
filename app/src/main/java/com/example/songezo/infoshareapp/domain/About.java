package com.example.songezo.infoshareapp.domain;

/**
 * Created by VERNON on 2016/12/10.
 */
public class About {

    private Long id;
    private String aboutInfoshare;


    public About(Builder builderObjt){
        id = builderObjt.id;
        aboutInfoshare = builderObjt.aboutInfoshare;

    }

    public About( Long id, String aboutInfoshare){
        this.id = id;
        this.aboutInfoshare = aboutInfoshare;

    }


    public Long getId() {
        return id;
    }

    public String getAboutInfoshare() { return aboutInfoshare; }


    public static class Builder{
        private Long id;
        private String aboutInfoshare;

        public Builder aboutInfoshare(String aboutInfoshare){
            this.aboutInfoshare = aboutInfoshare;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copyObj(About aboutObj){
            this.id = aboutObj.getId();
            this.aboutInfoshare = aboutObj.getAboutInfoshare();
            return this;
        }

        public About build(){
            return new About(this);
        }
    }
}
