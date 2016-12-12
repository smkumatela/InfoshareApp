package com.example.songezo.infoshareapp.domain;

import java.util.Date;

/**
 * Created by Songezo on 2016-12-09.
 */
public class Patient {
    private long id;
    private String name;
    private String address;
    private String reasonForVisit;
    private Date dateOfBirth;
    private String language;
    private int telephone;
    private boolean gender;
    private String medicalHistory;
    private String toDo;

    public Patient(Builder builderObj){
        id = builderObj.id;
        name = builderObj.name;
        address = builderObj.address;
        reasonForVisit = builderObj.reasonForVisit;
        dateOfBirth = builderObj.dateOfBirth;
        language = builderObj.language;
        telephone = builderObj.telephone;
        gender = builderObj.gender;
        medicalHistory = builderObj.medicalHistory;
        toDo = builderObj.toDo;
    }

    public Patient(long id, String name, String address, String reasonForVisit, Date dateOfBirth, String language, int telephone, boolean gender, String medicalHistory, String toDo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.reasonForVisit = reasonForVisit;
        this.dateOfBirth = dateOfBirth;
        this.language = language;
        this.telephone = telephone;
        this.gender = gender;
        this.medicalHistory = medicalHistory;
        this.toDo = toDo;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }


    public int getTelephone() {
        return telephone;
    }

    public boolean getGender() {
        return gender;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public String getToDo() {
        return toDo;
    }

    public Patient() {
    }

    public static class Builder{
        private long id;
        private String name;
        private String address;
        private String reasonForVisit;
        private Date dateOfBirth;
        private String language;
        private int telephone;
        private boolean gender;
        private String medicalHistory;
        private String toDo;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder reasonForVisit(String reasonForVisit){
            this.reasonForVisit = reasonForVisit;
            return this;
        }

        public Builder date(Date date){
            this.dateOfBirth = date;
            return this;
        }

        public Builder language(String language){
            this.language = language;
            return this;
        }

        public Builder telephone(int telephone){
            this.telephone = telephone;
            return this;
        }

        public Builder gender(boolean gender){
            this.gender = gender;
            return this;
        }

        public Builder medicalHistory(String medicalHistory){
            this.medicalHistory = medicalHistory;
            return this;
        }

        public Builder toDo(String toDo){
            this.toDo = toDo;
            return this;
        }

        public Builder copyObj(Patient patientObj){
            this.id = patientObj.getId();
            this.name = patientObj.getName();
            this.address = patientObj.getAddress();
            this.reasonForVisit = patientObj.getReasonForVisit();
            this.dateOfBirth = patientObj.getDateOfBirth();
            this.language = patientObj.getLanguage();
            this.telephone = patientObj.getTelephone();
            this.gender = patientObj.getGender();
            this.medicalHistory = patientObj.getMedicalHistory();
            this.toDo = patientObj.getToDo();
            return this;
        }

        public Patient build(){
            return new Patient(this);
        }
    }
}
