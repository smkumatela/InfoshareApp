package com.example.songezo.infoshareapp.services.toDo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.songezo.infoshareapp.conf.util.App;
import com.example.songezo.infoshareapp.domain.ToDo;
import com.example.songezo.infoshareapp.factories.TodoFactory;
import com.example.songezo.infoshareapp.services.toDo.Impl.ToDoServiceImpl;

import junit.framework.Assert;

import java.util.Map;

/**
 * Created by Songezo on 2016-12-13.
 */
public class ToDoServiceTest extends AndroidTestCase {

    Map<String, String> values;
    Long id;
    int taskNumber;
    boolean done;

    private ToDoServiceImpl toDoServiceImpl;
    private boolean isBound;
    private static final String TAG ="To Do TEST";

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), ToDoServiceImpl.class);
        App.context = this.getContext();
        toDoServiceImpl = ToDoServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ToDoServiceImpl.ToDoServiceLocalBinder binder
                    = (ToDoServiceImpl.ToDoServiceLocalBinder)service;
            toDoServiceImpl = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    public void testCreateEntities() throws Exception {
        values.put("walk patients", "Exercises");
        values.put("comments", "comments about treatment");
        id = 5101520L;
        ToDo toDoEntity = TodoFactory.createToDo(values, taskNumber, done);
        ToDo newToDoList = toDoServiceImpl.saveToDo(toDoEntity);
        Assert.assertNotNull(TAG + " CREATE", newToDoList);
    }
}
