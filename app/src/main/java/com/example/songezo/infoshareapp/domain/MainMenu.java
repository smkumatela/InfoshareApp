package com.example.songezo.infoshareapp.domain;

/**
 * Created by asiphe.dyani on 2016/12/09.
 */

public class MainMenu {

    private Long id;
    //private MyPatients myPatients;
    private ShareStories stories;
    private MessagingContacts messagingContacts;
    private SeeStories seeStories;
    //private Extras extras


    public MainMenu(Builder builderObjt) {
        id = builderObjt.id;
        //myPatients = builderObjt.myPatients;
        stories = builderObjt.stories;
        messagingContacts = builderObjt.messagingContacts;
        seeStories = builderObjt.seeStories;
        // extras = builderObjt.extras;
    }


      public MainMenu(/*MyPatients myPatients,*/ ShareStories stories, MessagingContacts messagingContacts,SeeStories seeStories,/*Extras extras,*/ Long id){
         this.id = id;
         //this.myPatients = myPatients;
         this.stories = stories;
         this.messagingContacts = messagingContacts;
         this.seeStories = seeStories;
         //this.extras = extras;
       }

    /*public MyPatients getMyPatients() {
        return myPatients;
    }*/

    public ShareStories getStories () {
        return stories;
    }

    public MessagingContacts getMessagingContacts() {
        return messagingContacts;
    }

    public SeeStories getSeeStories() {
        return seeStories;
    }

    /*public Extras getExtras() {
        return extras;
    }*/


    public Long getId() {
        return id;
    }


    public static class Builder{
        private Long id;
        //private MyPatients myPatients;
        private ShareStories stories;
        private MessagingContacts messagingContacts;
        private SeeStories seeStories;
        //private Extras extras


        /*public Builder myPatients(MyPatients myPatients){
            this.myPatients = myPatients;
            return this;
        }*/

        public Builder stories(ShareStories stories){
            this.stories = stories;
            return this;
        }

        public Builder messagingContacts(MessagingContacts messagingContacts){
            this.messagingContacts = messagingContacts;
            return this;
        }

        public Builder seeStories(SeeStories seeStories){
            this.seeStories = seeStories;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        /*public Builder extras(Extras extras){
            this.extras = extras;
            return this;
        }*/

        public Builder copyObj(MainMenu mainMenuObj){
            this.id = mainMenuObj.getId();
            //this.myPatients = myPatients.getMyPatients();
            this.stories = mainMenuObj.getStories();
            this.messagingContacts = mainMenuObj.getMessagingContacts();
            this.seeStories = mainMenuObj.getSeeStories();
            //this.extras = mainMenuObj.getExtras();
            return this;
        }

        public MainMenu build(){
            return new MainMenu(this);
        }
    }

    }



