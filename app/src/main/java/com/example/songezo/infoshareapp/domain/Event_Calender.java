package com.example.songezo.infoshareapp.domain;

/**
 * Created by Mandisi on 12/9/2016.
 */

public class Event_Calender {
    private Long id;
    private Organisation organisation;

    public Event_Calender(Builder builderObjt){
        id = builderObjt.id;
        organisation = builderObjt.organisation;
    }

    public Event_Calender(Organisation organisation, Long id){
        this.id = id;
        this.organisation = organisation;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public Long getId() {
        return id;
    }

    public static class Builder{
        private Long id;
        private Organisation organisation;

        public Builder organisation(Organisation organisation){
            this.organisation = organisation;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copyObj(Event_Calender event_CalenderObj){
            this.id = event_CalenderObj.getId();
            this.organisation = event_CalenderObj.getOrganisation();
            return this;
        }

        public Event_Calender build(){
            return new Event_Calender(this);
        }
    }
}