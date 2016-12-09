package com.example.songezo.infoshareapp.domain;

import java.util.Date;

/**
 * Created by Songezo on 2016-12-09.
 */
public class Patient {
    private long id;
    private long name;
    private long address;
    private long reasonForVisit;
    private Date dateOfBirth;
    private long language;
    private int telephone;
    private boolean gender;

    public Patient(Builder builderObj){
        id = builderObj.id;
        name = builderObj.name;
        address = builderObj.address;
        reasonForVisit = builderObj.reasonForVisit;
        dateOfBirth = builderObj.dateOfBirth;
        language = builderObj.language;
        telephone = builderObj.telephone;
        gender = builderObj.gender;
    }

    public Patient(long id, long name, long address, long reasonForVisit, Date dateOfBirth, long language, int telephone, boolean gender) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.reasonForVisit = reasonForVisit;
        this.dateOfBirth = dateOfBirth;
        this.language = language;
        this.telephone = telephone;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public long getName() {
        return name;
    }

    public long getAddress() {
        return address;
    }

    public long getReasonForVisit() {
        return reasonForVisit;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public long getLanguage() {
        return language;
    }

    public int getTelephone() {
        return telephone;
    }

    public boolean getGender() {
        return gender;
    }

    public Patient() {
    }

    public static class Builder{
        private long id;
        private long name;
        private long address;
        private long reasonForVisit;
        private Date dateOfBirth;
        private long language;
        private int telephone;
        private boolean gender;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder name(long name){
            this.name = name;
            return this;
        }

        public Builder address(long address){
            this.address = address;
            return this;
        }

        public Builder reasonForVisit(long reasonForVisit){
            this.reasonForVisit = reasonForVisit;
            return this;
        }

        public Builder date(Date date){
            this.dateOfBirth = date;
            return this;
        }

        public Builder language(long language){
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

        public Builder copyObj(Patient patientObj){
            this.id = patientObj.getId();
            this.name = patientObj.getName();
            this.address = patientObj.getAddress();
            this.reasonForVisit = patientObj.getReasonForVisit();
            this.dateOfBirth = patientObj.getDateOfBirth();
            this.language = patientObj.getLanguage();
            this.telephone = patientObj.getTelephone();
            this.gender = patientObj.getGender();
            return this;
        }

        public Patient build(){
            return new Patient(this);
        }
    }
}
