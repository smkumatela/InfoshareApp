package com.example.songezo.infoshareapp.domain;

/**
 * Created by Mandisi on 12/9/2016.
 */

public class Caregiver {
    private Long id;
    //private ContactList contactList;

    public Caregiver(Builder builderObjt){
        id = builderObjt.id;
        // contactList = builderObjt.contactList;
    }

    public Caregiver(/*Long contactList,*/ Long id){
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

        public Builder copyObj(Caregiver caregiverObj){
            this.id = caregiverObj.getId();
            //this.contactList = caregiverObj.getContactList();
            return this;
        }

        public Caregiver build(){
            return new Caregiver(this);
        }
    }
}
