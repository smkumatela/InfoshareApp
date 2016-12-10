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
    private long location;

    public MyPatient(Builder builderObj){
        id = builderObj.id;
        pDate = builderObj.pDate;
        time = builderObj.time;
        location = builderObj.location;
    }

    public MyPatient(long id, Date pDate, Time time, long location) {
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

    public long getLocation() {
        return location;
    }

    public static class Builder{
        private long id;
        private Date pDate;
        private Time time;
        private long location;

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

        public Builder location(long location){
            this.location = location;
            return this;
        }

        public Builder copyObj(MyPatient myPatientObj){
            this.id = myPatientObj.getId();
            this.pDate = myPatientObj.getpDate();
            this.time = myPatientObj.getTime();
            this.location = myPatientObj.getLocation();
            return this;
        }

        public MyPatient build(){
            return new MyPatient(this);
        }
    }
}
