package com.example.songezo.infoshareapp.domain;

/**
 * Created by Mandisi on 12/9/2016.
 */

public class Suggestion_Box {
    private Long id;
    //private Questionnaire questionnaire;


    public Suggestion_Box(Builder builderObjt){
        id = builderObjt.id;
        // questionnaire = builderObjt.questionnaire;
    }

    public Suggestion_Box(/*Long questionnaire,*/ Long id){
        this.id = id;
        //this.questionnaire = questionnaire;
    }

                /*public questionnaire getQuestionnaire() {
         return questionnaire;
     }*/

    public Long getId() {
        return id;
    }


    public static class Builder{
        private Long id;
        //private Questionnaire questionnaire;

                        /*public Builder questionnaire(Questionnaire questionnaire){
             this.questionnaire = questionnaire;
             return this;
         }*/

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copyObj(Suggestion_Box suggestion_BoxObj){
            this.id = suggestion_BoxObj.getId();
            //this.questionnaire = suggestion_BoxObj.getQuestionnaire();
            return this;
        }

        public Suggestion_Box build(){
            return new Suggestion_Box(this);
        }
    }
}
