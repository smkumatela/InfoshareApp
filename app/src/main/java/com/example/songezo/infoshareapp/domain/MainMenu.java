package com.example.songezo.infoshareapp.domain;

/**
 * Created by asiphe.dyani on 2016/12/09.
 */

public class MainMenu {

    private Long id;
    private String myPatient;
    private String stories;
    private String messagingContacts;
    private String seeStories;
    private String extras;


    public MainMenu(Builder builderObjt) {
        id = builderObjt.id;
        myPatient = builderObjt.myPatient;
        stories = builderObjt.stories;
        messagingContacts = builderObjt.messagingContacts;
        seeStories = builderObjt.seeStories;
        extras = builderObjt.extras;
    }


      public MainMenu(String myPatient, String stories, String messagingContacts,String seeStories,String extras, Long id){
         this.id = id;
         this.myPatient = myPatient;
         this.stories = stories;
         this.messagingContacts = messagingContacts;
         this.seeStories = seeStories;
         this.extras = extras;
       }

    public String getMyPatient() {
        return myPatient;
    }

    public String getStories () {
        return stories;
    }

    public String getMessagingContacts() {
        return messagingContacts;
    }

    public String getSeeStories() {
        return seeStories;
    }

    public String getExtras() {
        return extras;
    }


    public Long getId() {
        return id;
    }


    public static class Builder{
        private Long id;
        private String myPatient;
        private String stories;
        private String messagingContacts;
        private String seeStories;
        private String extras;


        public Builder myPatient(String myPatient){
            this.myPatient = myPatient;
            return this;
        }

        public Builder stories(String stories){
            this.stories = stories;
            return this;
        }

        public Builder messagingContacts(String messagingContacts){
            this.messagingContacts = messagingContacts;
            return this;
        }

        public Builder seeStories(String seeStories){
            this.seeStories = seeStories;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder extras(String extras){
            this.extras = extras;
            return this;
        }

        public Builder copyObj(MainMenu mainMenuObj){
            this.id = mainMenuObj.getId();
            this.myPatient = mainMenuObj.getMyPatient();
            this.stories = mainMenuObj.getStories();
            this.messagingContacts = mainMenuObj.getMessagingContacts();
            this.seeStories = mainMenuObj.getSeeStories();
            this.extras = mainMenuObj.getExtras();
            return this;
        }

        public MainMenu build(){
            return new MainMenu(this);
        }
    }

    }



