package com.example.songezo.infoshareapp.services.toDo.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.songezo.infoshareapp.domain.ToDo;
import com.example.songezo.infoshareapp.factories.TodoFactory;
import com.example.songezo.infoshareapp.repository.toDo.ToDoRepository;
import com.example.songezo.infoshareapp.services.toDo.ToDoService;

import java.util.Set;

/**
 * Created by Songezo on 2016-12-13.
 */
public class ToDoServiceImpl extends Service implements ToDoService {

    private ToDoRepository repository;

    private final IBinder localBinder = new ToDoServiceLocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }


    private static ToDoServiceImpl service = null;

    public static ToDoServiceImpl getInstance(){
        if (service == null)
            service = new ToDoServiceImpl();
        return service;
    }

    public class ToDoServiceLocalBinder extends Binder {
        public ToDoServiceImpl getService(){
            return ToDoServiceImpl.this;
        }
    }

    //@Nullable

    @Override
    public ToDo getToDoByID(Long id) {
        if(repository.findById(id) == null)
            return null;
        else
            return repository.findById(id);
    }

    @Override
    public ToDo saveToDo(ToDo entity) {
        return repository.save(entity);
    }

    @Override
    public Set<ToDo> findAll() {
        return repository.findAll();
    }

}
