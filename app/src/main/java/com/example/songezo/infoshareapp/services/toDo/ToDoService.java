package com.example.songezo.infoshareapp.services.toDo;

import com.example.songezo.infoshareapp.domain.ToDo;

import java.util.Set;

/**
 * Created by Songezo on 2016-12-13.
 */
public interface ToDoService {

    ToDo getToDoByID(Long id);

    ToDo saveToDo(ToDo entity);

    Set<ToDo> findAll();
}
