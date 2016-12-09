package com.example.songezo.infoshareapp.domain;


import java.util.Date;
import java.util.Locale;

/**
 * Created by Songezo on 2016-12-09.
 */
public class MedicalHistory {
    private Long id;
    private Date date;
    private Long task;
    private Long comments;

    public MedicalHistory(Builder builderObjt){
        id = builderObjt.id;
        date = builderObjt.date;
        task = builderObjt.task;
        comments = builderObjt.comments;
    }

    public MedicalHistory(Date date, Long task, Long comments, Long id){
        this.id = id;
        this.date = date;
        this.task = task;
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public Long getTask() {
        return task;
    }

    public Long getComments() {
        return comments;
    }

    public Long getId() {
        return id;
    }

    private MedicalHistory(){
    }

    public static class Builder{
        private Long id;
        private Date date;
        private Long task;
        private Long comments;

        public Builder date(Date date){
            this.date = date;
            return this;
        }

        public Builder task(Long task){
            this.task = task;
            return this;
        }

        public Builder comments(Long comments){
            this.comments = comments;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copyObj(MedicalHistory medicalHistoryObj){
            this.id = medicalHistoryObj.getId();
            this.date = medicalHistoryObj.getDate();
            this.task = medicalHistoryObj.getTask();
            this.comments = medicalHistoryObj.getComments();
            return this;
        }

        public MedicalHistory build(){
            return new MedicalHistory(this);
        }
    }


}
