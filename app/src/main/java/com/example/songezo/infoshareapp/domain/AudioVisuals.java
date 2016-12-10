package com.example.songezo.infoshareapp.domain;

/**
 * Created by VERNON on 2016/12/10.
 */
public class AudioVisuals {

    private Long id;
    private Audio aud;
    private Video vid;


    public AudioVisuals(Builder builderObjt) {
        id = builderObjt.id;
        aud = builderObjt.aud;
        vid = builderObjt.vid;
    }


    public AudioVisuals( Audio aud, Video vid,Long id){
        this.id = id;
        this.aud = aud;
        this.vid = vid;
    }



    public Audio getAudio () {
        return aud;
    }

    public Video getVideo() {
        return vid;
    }

    public Long getId() {
        return id;
    }


    public static class Builder{
        private Long id;
        private Audio aud;
        private Video vid;

        public Builder aud(Audio aud){
            this.aud = aud;
            return this;
        }

        public Builder vid(Video vid){
            this.vid = vid;
            return this;
        }


        public Builder id(Long id){
            this.id = id;
            return this;
        }


        public Builder copyObj(AudioVisuals audioVisualsMenuObj){
            this.id = audioVisualsMenuObj.getId();
            this.aud = audioVisualsMenuObj.getAudio();
            this.vid = audioVisualsMenuObj.getVideo();
            return this;
        }

        public AudioVisuals build(){
            return new AudioVisuals(this);
        }
    }
}
