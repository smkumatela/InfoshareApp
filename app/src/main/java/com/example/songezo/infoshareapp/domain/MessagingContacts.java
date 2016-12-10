package com.example.songezo.infoshareapp.domain;

/**
 * Created by asiphe.dyani on 2016/12/09.
 */

public class MessagingContacts {
    private Long id;
    //private CareGivers careGivers;
    private Organisation organisation;

    public MessagingContacts(Builder builderObjt){
        id = builderObjt.id;
       // careGivers = builderObjt.careGivers;
        organisation = builderObjt.organisation;
    }

    public MessagingContacts(/*CareGivers careGivers,*/ Organisation organisation, Long id){
        this.id = id;
        //this.careGivers = careGivers;
        this.organisation = organisation;
    }

    /*public CareGivers getCareGivers() {
        return careGivers;
    }*/

    public Organisation getOrganisation() {
        return organisation;
    }

    public Long getId() {
        return id;
    }

    public static class Builder{
        private Long id;
        //private CareGivers careGivers;
        private Organisation organisation;

        /*public Builder careGivers(CareGivers careGivers){
            this.careGivers = careGivers;
            return this;
        }*/

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
            //this.careGivers = messagingContactsObj.getCareGivers();
            this.organisation = messagingContactsObj.getOrganisation();
            return this;
        }

        public MessagingContacts build(){
            return new MessagingContacts(this);
        }
    }


}
