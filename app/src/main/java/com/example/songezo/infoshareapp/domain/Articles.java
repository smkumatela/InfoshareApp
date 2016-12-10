package com.example.songezo.infoshareapp.domain;

import java.util.Date;

/**
 * Created by VERNON on 2016/12/10.
 */
public class Articles {

    private Long id;
    private String name;
    private Date date;
    private String topic;
    private String category;

    public Articles(Builder builderObjt){
        id = builderObjt.id;
        name = builderObjt.name;
        date = builderObjt.date;
        topic = builderObjt.topic;
        category = builderObjt.category;
    }

    public Articles(Long id, String name, Date date, String topic, String category){
        this.id = id;
        this.name = name;
        this.date = date;
        this.topic = topic;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() { return date; }

    public String getTopic() { return topic;}

    public String getCategory() { return category;}

    public static class Builder{
        private Long id;
        private String name;
        private Date date;
        private String topic;
        private String category;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder date(Date date){
            this.date = date;
            return this;
        }

        public Builder topic(String topic){
            this.topic = topic;
            return this;
        }
        public Builder category(String category){
            this.category = category;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copyObj(Articles articlesObj){
            this.id = articlesObj.getId();
            this.date = articlesObj.getDate();
            this.name = articlesObj.getName();
            this.topic = articlesObj.getTopic();
            this.category = articlesObj.getCategory();
            return this;
        }

        public Articles build(){
            return new Articles(this);
        }
    }
}
