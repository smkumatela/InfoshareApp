package com.example.songezo.infoshareapp.domain;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Songezo on 2016-12-09.
 */
public class MyPatient {
    private long id;
    private Date pDate;
    private Time time;
    private String location;
    private String name;

    public MyPatient(Builder builderObj){
        id = builderObj.id;
        pDate = builderObj.pDate;
        time = builderObj.time;
        location = builderObj.location;
        name = builderObj.name;
    }

    public MyPatient(long id, Date pDate, Time time, String location, String name) {
        this.id = id;
        this.pDate = pDate;
        this.time = time;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public Date getpDate() {
        return pDate;
    }

    public Time getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public static class Builder{
        private long id;
        private Date pDate;
        private Time time;
        private String location;
        private String name;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder pDate(Date pDate){
            this.pDate = pDate;
            return this;
        }

        public Builder time(Time time){
            this.time = time;
            return this;
        }

        public Builder location(String location){
            this.location = location;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder copyObj(MyPatient myPatientObj){
            this.id = myPatientObj.getId();
            this.pDate = myPatientObj.getpDate();
            this.time = myPatientObj.getTime();
            this.location = myPatientObj.getLocation();
            this.name = myPatientObj.getName();
            return this;
        }

        public MyPatient build(){
            return new MyPatient(this);
        }
    }
}
