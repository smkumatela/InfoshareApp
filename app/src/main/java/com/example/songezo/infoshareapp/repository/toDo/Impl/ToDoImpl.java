package com.example.songezo.infoshareapp.repository.toDo.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.domain.ToDo;
import com.example.songezo.infoshareapp.repository.toDo.ToDoRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Songezo on 2016-12-12.
 */
public class ToDoImpl extends SQLiteOpenHelper implements ToDoRepository {

    public static final String TABLE_NAME = "my_Patient";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TASK_NUMBER = "taskNumber";
    public static final String COLUMN_TASK = "task";
    public static final String COLUMN_DONE = "done";
    public static final String COLUMN_COMMENT_SECTION = "commentSection";

    private static final String DATABASE_CREATE = "CREATE TABLE"
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TASK_NUMBER + " NUMBER NOT NULL, "
            + COLUMN_TASK + "TIME NOT NULL, "
            + COLUMN_DONE + "TEXT NOT NULL, "
            + COLUMN_COMMENT_SECTION + "TEXT NOT NULL );";

    public ToDoImpl(Context context) {
        super(context, name, factory, version);
    }

    public void open() throws SQLException {
        db = this.getReadableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public ToDo findById(Long aLong) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_TASK_NUMBER,
                        COLUMN_TASK,
                        COLUMN_DONE,
                        COLUMN_COMMENT_SECTION
                },
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(aLong)},
                null,
                null,
                null);
        if (cursor.moveToFirst()){
            final ToDo toDo = new ToDo.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .taskNumber(cursor.getInt(cursor.getColumnIndex(COLUMN_TASK_NUMBER)))
                    .task(cursor.getString(cursor.getColumnIndex(COLUMN_TASK)))
                    .commentSection(cursor.getString(cursor.getColumnIndex(COLUMN_COMMENT_SECTION)))
                    .build();
            return toDo;
        } else {
            return null;
        }
    }

    @Override
    public ToDo save(ToDo entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_TASK_NUMBER, entity.getCommentSection());
        values.put(COLUMN_TASK, entity.getTask());
        values.put(COLUMN_DONE, entity.getDone());
        values.put(COLUMN_COMMENT_SECTION, entity.getCommentSection());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        ToDo InsertedEntity = new ToDo.Builder()
                .copyObj(entity)
                .id(id)
                .build();
        return InsertedEntity;
    }

    @Override
    public ToDo update(ToDo entity) {
        open();
        ContentValues values =  new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_TASK_NUMBER, entity.getCommentSection());
        values.put(COLUMN_TASK, entity.getTask());
        values.put(COLUMN_DONE, entity.getDone());
        values.put(COLUMN_COMMENT_SECTION, entity.getCommentSection());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public ToDo delete(ToDo entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Set<ToDo> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<ToDo> toDoHashSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                final ToDo toDo = new ToDo.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .taskNumber(cursor.getInt(cursor.getColumnIndex(COLUMN_TASK_NUMBER)))
                        .task(cursor.getString(cursor.getColumnIndex(COLUMN_TASK)))
                        .commentSection(cursor.getString(cursor.getColumnIndex(COLUMN_COMMENT_SECTION)))
                        .build();
                toDoHashSet.add(toDo);
            }   while (cursor.moveToNext());
        }
        return toDoHashSet;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME, null, null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", wgich will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
