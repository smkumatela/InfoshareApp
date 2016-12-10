package com.example.songezo.infoshareapp.domain;

/**
 * Created by Mandisi on 12/9/2016.
 */

public class Extras {
    private Long id;
    private Event_Calender event_Calender;
    private Weather weather;
    private Suggestion_Box suggestion_Box;
    //private Audio_Visuals audio_Visuals;
    //private About about;


    public Extras(Builder builderObjt){
        id = builderObjt.id;
        event_Calender = builderObjt.event_Calender;
        weather = builderObjt.weather;
        suggestion_Box = builderObjt.suggestion_Box;
        //audio_Visuals = builderObjt.audio_Visuals;
        //about = builderObjt.about;
    }

    public Extras(Event_Calender event_Calender,Weather weather,Suggestion_Box suggestion_Box/*,Audio_Visuals audio_Visuals,About about*/,Long id){
        this.id = id;
        this.event_Calender = event_Calender;
        this.weather = weather;
        this.suggestion_Box = suggestion_Box;
        //this.audio_Visuals = audio_Visuals;
        //this.about = about;
    }
    public Event_Calender getEvent_Calender() {
        return event_Calender;
    }
    public Weather getWeather() {
         return weather;
    }
    public Suggestion_Box getSuggestion_Box() {
         return suggestion_Box;
    }
    /*public Audio_Visuals getAudio_Visuals() {
         return audio_Visuals;
    }*/
    /*public About getAbout() {
         return about;
    }*/


    public Long getId() {
        return id;
    }

    public static class Builder{
        private Long id;
        private Weather weather;
        private Event_Calender event_Calender;
        private Suggestion_Box suggestion_Box;
        //private Audio_Visuals audio_Visuals;
        //private About about;


        public Builder event_Calender(Event_Calender event_Calender){
            this.event_Calender = event_Calender;
            return this;
        }

        public Builder weather(Weather weather){
             this.weather = weather;
             return this;
         }
        public Builder suggestion_Box(Suggestion_Box suggestion_Box){
             this.suggestion_Box = suggestion_Box;
             return this;
         }
        /*public Builder audio_Visuals(Audio_Visuals audio_Visuals){
             this.audio_Visuals = audio_Visuals;
             return this;
         }*/
        /*public Builder about(About about){
             this.about = about;
             return this;
         }*/

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copyObj(Extras extrasObj){
            this.id = extrasObj.getId();
            this.weather = extrasObj.getWeather();
            this.event_Calender = extrasObj.getEvent_Calender();
            this.suggestion_Box = extrasObj.getSuggestion_Box();
           // this.audio_Visuals = extrasObj.getAudio_Visuals();
           // this.about = extrasObj.getAbout();

            return this;
        }

        public Extras build(){
            return new Extras(this);
        }
    }
}
