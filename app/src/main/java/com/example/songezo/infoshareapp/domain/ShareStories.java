package com.example.songezo.infoshareapp.domain;

/**
 * Created by asiphe.dyani on 2016/12/09.
 */

public class ShareStories {

      private Long id;
      private String share;
      private String clear;

    public ShareStories(Builder builderObjt){
        id = builderObjt.id;
        share = builderObjt.share;
        clear = builderObjt.clear;
    }

    public ShareStories(String share, String clear, Long id){
        this.id = id;
        this.share = share;
        this.clear = clear;
    }

    public String getShare() {
        return share;
    }

    public String getClear() {
        return clear;
    }

    public Long getId() {
        return id;
    }



    public static class Builder{
        private Long id;
        private String share;
        private String clear;

        public Builder share(String share){
            this.share = share;
            return this;
        }

        public Builder clear(String clear){
            this.clear = clear;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copyObj(ShareStories shareStoriesObj){
            this.id = shareStoriesObj.getId();
            this.share = shareStoriesObj.getShare();
            this.clear = shareStoriesObj.getClear();
            return this;
        }

        public ShareStories build(){
            return new ShareStories(this);
        }
    }


}
