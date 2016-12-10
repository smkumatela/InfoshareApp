package com.example.songezo.infoshareapp.domain;

/**
 * Created by Mandisi on 12/9/2016.
 */

public class Weather {
    private Long id;
    //private Today today;
    //private Day_Forecast day_Forecast;

    public Weather(Builder builderObjt){
        id = builderObjt.id;
        // today = builderObjt.today;
        //day_Forecast = builderObjt.day_Forecast;
    }

    public Weather(/*Today today, Day_Forecast day_Forecast,*/ Long id){
        this.id = id;
        //this.today = today;
        //this.day_Forecast = day_Forecast;
    }

    /*public Today getToday() {
         return today;
    }*/

    /*public Day_Forecast getDay_Forecast() {
        return day_Forecast;
    }*/

    public Long getId() {
        return id;
    }

    public static class Builder{
        private Long id;
        //private Today today;
        //private day_Forecast day_Forecast;

        /*public Builder today(Today today){
             this.today = today;
             return this;
         }*/

        /*public Builder day_Forecast(Day_Forecast day_Forecast){
            this.day_Forecast = day_Forecast;
            return this;
        }*/

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copyObj(Weather weatherObj){
            this.id = weatherObj.getId();
            //this.today = weatherObj.getToday();
            //this.day_Forecast = weatherObj.getDay_Forecast();
            return this;
        }

        public Weather build(){
            return new Weather(this);
        }
    }
}