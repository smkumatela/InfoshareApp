package com.example.songezo.infoshareapp.domain;

/**
 * Created by Songezo on 2016-12-09.
 */
public class ToDo {
    private long id;
    private int taskNumber;
    private String task;
    private boolean done;
    private String commentSection;
    //private TaskTable taskTable;

    public ToDo(Builder builderObj){
        id = builderObj.id;
        taskNumber = builderObj.taskNumber;
        task = builderObj.task;
        done = builderObj.done;
        commentSection = builderObj.commentSection;
    }

    public ToDo(long id, int taskNumber, String task, boolean done, String commentSection) {
        this.id = id;
        this.taskNumber = taskNumber;
        this.task = task;
        this.done = done;
        this.commentSection = commentSection;
    }

    public long getId() {
        return id;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public boolean getDone() {
        return done;
    }

    public String getTask() {
        return task;
    }

    public String getCommentSection() {
        return commentSection;
    }

    public ToDo() {
    }

    public static class Builder{
        private long id;
        private int taskNumber;
        private String task;
        private boolean done;
        private String commentSection;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder taskNumber(int taskNumber){
            this.taskNumber = taskNumber;
            return this;
        }

        public Builder task(String task){
            this.task = task;
            return this;
        }

        public Builder done(boolean done){
            this.done = done;
            return this;
        }

        public Builder commentSection(String commentSection){
            this.commentSection = commentSection;
            return this;
        }

        public Builder copyObj(ToDo toDoObj){
            this.id = toDoObj.getId();
            this.commentSection = toDoObj.getCommentSection();
            this.done = toDoObj.getDone();
            this.task = toDoObj.getTask();
            this.taskNumber = toDoObj.getTaskNumber();
            return this;
        }

        public ToDo build(){
            return new ToDo(this);
        }
    }
}
