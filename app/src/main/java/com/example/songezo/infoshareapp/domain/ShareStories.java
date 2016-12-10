package com.example.songezo.infoshareapp.domain;

/**
 * Created by asiphe.dyani on 2016/12/09.
 */

public class ShareStories {

      private Long id;
    //private TextBox textBox;
    //private UploadAFile uploadafile;
      private Long share;
      private Long clear;



    public ShareStories(Builder builderObjt){
        id = builderObjt.id;
        share = builderObjt.share;
        clear = builderObjt.clear;
    }

    public ShareStories(Long share, Long clear, Long id){
        this.id = id;
        this.share = share;
        this.clear = clear;
    }

    public Long getShare() {
        return share;
    }

    public Long getClear() {
        return clear;
    }

    public Long getId() {
        return id;
    }



    public static class Builder{
        private Long id;
        private Long share;
        private Long clear;

        public Builder share(Long share){
            this.share = share;
            return this;
        }

        public Builder clear(Long clear){
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
