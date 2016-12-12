package com.example.songezo.infoshareapp.domain;

/**
 * Created by asiphe.dyani on 2016/12/09.
 */

public class MessagingContacts {
    private Long id;
    private Caregiver caregiver;
    private Organisation organisation;

    public MessagingContacts(Builder builderObjt){
        id = builderObjt.id;
        caregiver = builderObjt.caregiver;
        organisation = builderObjt.organisation;
    }

    public MessagingContacts(Caregiver caregiver, Organisation organisation, Long id){
        this.id = id;
        this.caregiver = caregiver;
        this.organisation = organisation;
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public Long getId() {
        return id;
    }

    public static class Builder{
        private Long id;
        private Caregiver caregiver;
        private Organisation organisation;

        public Builder caregiver(Caregiver careGiver){
            this.caregiver = caregiver;
            return this;
        }

        public Builder organisation(Organisation organisation){
            this.organisation = organisation;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copyObj(MessagingContacts messagingContactsObj){
            this.id = messagingContactsObj.getId();
            this.caregiver = messagingContactsObj.getCaregiver();
            this.organisation = messagingContactsObj.getOrganisation();
            return this;
        }

        public MessagingContacts build(){
            return new MessagingContacts(this);
        }
    }


}
