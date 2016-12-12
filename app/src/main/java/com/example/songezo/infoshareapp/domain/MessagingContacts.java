package com.example.songezo.infoshareapp.domain;

/**
 * Created by asiphe.dyani on 2016/12/09.
 */

public class MessagingContacts {
    private Long id;
    private String caregiver;
    private String organisation;

    public MessagingContacts(Builder builderObjt){
        id = builderObjt.id;
        caregiver = builderObjt.caregiver;
        organisation = builderObjt.organisation;
    }

    public MessagingContacts(String caregiver, String organisation, Long id){
        this.id = id;
        this.caregiver = caregiver;
        this.organisation = organisation;
    }

    public String getCaregiver() {
        return caregiver;
    }

    public String getOrganisation() {
        return organisation;
    }

    public Long getId() {
        return id;
    }

    public static class Builder{
        private Long id;
        private String caregiver;
        private String organisation;

        public Builder caregiver(String careGiver){
            this.caregiver = caregiver;
            return this;
        }

        public Builder organisation(String organisation){
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
