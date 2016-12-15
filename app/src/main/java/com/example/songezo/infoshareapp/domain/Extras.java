package com.example.songezo.infoshareapp.domain;

/**
 * Created by Mandisi on 12/9/2016.
 */

public class Extras {
    private Long id;
    private String event_Calender;
    private String weather;
    private String suggestion_Box;
    private String audioVisuals;
    private String about;


    public Extras(Builder builderObjt) {
        id = builderObjt.id;
        event_Calender = builderObjt.event_Calender;
        weather = builderObjt.weather;
        suggestion_Box = builderObjt.suggestion_Box;
        audioVisuals = builderObjt.audioVisuals;
        about = builderObjt.about;
    }


    public Extras(String event_Calender, String weather, String suggestion_Box,String audioVisuals,String about, Long id){
        this.id = id;
        this.event_Calender = event_Calender;
        this.weather = weather;
        this.suggestion_Box = suggestion_Box;
        this.audioVisuals = audioVisuals;
        this.about = about;
    }

    public String getEvent_Calender() {
        return event_Calender;
    }

    public String getWeather () {
        return weather;
    }

    public String getSuggestion_Box() {
        return suggestion_Box;
    }

    public String getAudioVisuals() {
        return audioVisuals;
    }

    public String getAbout() {
        return about;
    }


    public Long getId() {
        return id;
    }


    public static class Builder{
        private Long id;
        private String event_Calender;
        private String weather;
        private String suggestion_Box;
        private String audioVisuals;
        private String about;


        public Builder event_Calender(String event_Calender){
            this.event_Calender = event_Calender;
            return this;
        }

        public Builder weather(String weather){
            this.weather = weather;
            return this;
        }

        public Builder suggestion_Box(String suggestion_Box){
            this.suggestion_Box = suggestion_Box;
            return this;
        }

        public Builder audioVisuals(String audioVisuals){
            this.audioVisuals = audioVisuals;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder about(String about){
            this.about = about;
            return this;
        }

        public Builder copyObj(Extras extrasObj){
            this.id = extrasObj.getId();
            this.event_Calender = extrasObj.getEvent_Calender();
            this.weather = extrasObj.getWeather();
            this.suggestion_Box = extrasObj.getSuggestion_Box();
            this.audioVisuals = extrasObj.getAudioVisuals();
            this.about = extrasObj.getAbout();
            return this;
        }

        public Extras build(){
            return new Extras(this);
        }
    }

}