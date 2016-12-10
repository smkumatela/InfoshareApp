package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.ToDo;

import java.util.Map;

/**
 * Created by Songezo on 2016-12-10.
 */
public class TodoFactory {
    ToDo toDo;

    private static TodoFactory todoList = null;

    public TodoFactory() {
    }

    public static TodoFactory getTodoListInstance(){
        if (todoList == null){
            todoList = new TodoFactory();
        }
        return todoList;
    }

    public static ToDo createToDo(Map<String, String> values, int taskNumber, boolean done){
        ToDo toDo1 = new ToDo.Builder()
                    .taskNumber(12)
                    .task(values.get("walk patients"))
                    .commentSection(values.get("comments"))
                    .done(done)
                    .id(3691215L)
                    .build();
        return toDo1;
    }

    @Override
    public String toString() {
        return "TodoFactory{" +
                "toDo=" + toDo +
                '}';
    }
}
