package com.example.songezo.infoshareapp.domain;

/**
 * Created by Mandisi on 12/9/2016.
 */

public class Event_Calender {
    private Long id;
    private String organization;

    public Event_Calender(Builder builderObjt){
        id = builderObjt.id;
        organization = builderObjt.organization;
    }

    public Event_Calender(String organization, Long id){
        this.id = id;
        this.organization = organization;
    }

    public String getOrganization() {
        return organization;
    }

    public Long getId() {
        return id;
    }


    public static class Builder{
        private Long id;
        private String organization;

        public Builder organization(String organization){
            this.organization = organization;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copyObj(Event_Calender event_CalenderObj){
            this.id = event_CalenderObj.getId();
            this.organization = event_CalenderObj.getOrganization();
            return this;
        }

        public Event_Calender build(){
            return new Event_Calender(this);
        }
    }
}
