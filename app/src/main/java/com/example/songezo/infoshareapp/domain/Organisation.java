package com.example.songezo.infoshareapp.domain;

/**
 * Created by asiphe.dyani on 2016/12/09.
 */

public class Organisation {
    private Long id;
    //private ContactList contactList;


    public Organisation(Builder builderObjt){
        id = builderObjt.id;
       // contactList = builderObjt.contactList;
    }

    public Organisation(/*Long contactList,*/ Long id){
        this.id = id;
        //this.contactList = contactList;
    }

    /*public ContactList getContactList() {
        return contactList;
    }*/

    public Long getId() {
        return id;
    }


    public static class Builder{
        private Long id;
        //private ContactList contactList;

        /*public Builder contactList(ContactList contactList){
            this.contactList = contactList;
            return this;
        }*/

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copyObj(Organisation organisationObj){
            this.id = organisationObj.getId();
            //this.contactList = organisationObj.getContactList();
            return this;
        }

        public Organisation build(){
            return new Organisation(this);
        }
    }

}
