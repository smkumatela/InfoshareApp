package com.example.songezo.infoshareapp.repository.seestories.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.conf.databases.DBConstants;
import com.example.songezo.infoshareapp.domain.SeeStories;
import com.example.songezo.infoshareapp.repository.seestories.SeeStoriesRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/11.
 */

public class SeeStoriesRepositoryImpl extends SQLiteOpenHelper implements SeeStoriesRepository {

    public static final String TABLE_NAME = "seestories";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "seestories_id";
    public static final String COLUMN_STORIES = "seestories_sharedstories";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_STORIES + " TEXT NOT NULL );";


    public SeeStoriesRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }


    @Override
    public SeeStories findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_STORIES},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final SeeStories seeStories = new SeeStories.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .stories(cursor.getString(cursor.getColumnIndex(COLUMN_STORIES)))
                    .build();

            return seeStories;
        } else {
            return null;
        }
    }

    @Override
    public SeeStories save(SeeStories entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_STORIES, entity.getStories().toString());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        SeeStories insertedEntity = new SeeStories.Builder()
                .copyObj(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public SeeStories update(SeeStories entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_STORIES, entity.getStories().toString());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public SeeStories delete(SeeStories entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<SeeStories> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<SeeStories> seeStoriesSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final SeeStories login = new SeeStories.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .stories(cursor.getString(cursor.getColumnIndex(COLUMN_STORIES)))
                        .build();
                seeStoriesSet.add(login);
            } while (cursor.moveToNext());
        }
        return seeStoriesSet;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
