package com.example.songezo.infoshareapp.repository.Extras.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.conf.databases.DBConstants;
import com.example.songezo.infoshareapp.domain.Extras;
import com.example.songezo.infoshareapp.repository.Extras.ExtrasRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mandisi on 12/14/2016.
 */

public class ExtrasRepositoryImpl extends SQLiteOpenHelper implements ExtrasRepository {


    public static final String TABLE_NAME = "extras";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "extras_id";
    public static final String COLUMN_EVENT_CALENDER = "extras_event_Calender";
    public static final String COLUMN_WEATHER = "extras_weather";
    public static final String COLUMN_SUGGESTION_BOX = "extras_suggestion_Box";
    public static final String COLUMN_AUDIOVISUALS = "extras_audioVisuals";
    public static final String COLUMN_ABOUT = "extras_about";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_EVENT_CALENDER + " TEXT NOT NULL , "
            + COLUMN_WEATHER + " TEXT NOT NULL , "
            + COLUMN_SUGGESTION_BOX + " TEXT NOT NULL , "
            + COLUMN_AUDIOVISUALS + " TEXT NOT NULL , "
            + COLUMN_ABOUT + " TEXT NOT NULL );";


    public ExtrasRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }


    @Override
    public Extras findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_EVENT_CALENDER,
                        COLUMN_WEATHER,
                        COLUMN_SUGGESTION_BOX,
                        COLUMN_AUDIOVISUALS,
                        COLUMN_ABOUT},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Extras extras = new Extras.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .event_Calender(cursor.getString(cursor.getColumnIndex(COLUMN_EVENT_CALENDER)))
                    .weather(cursor.getString(cursor.getColumnIndex(COLUMN_WEATHER)))
                    .suggestion_Box(cursor.getString(cursor.getColumnIndex(COLUMN_SUGGESTION_BOX)))
                    .audioVisuals(cursor.getString(cursor.getColumnIndex(COLUMN_AUDIOVISUALS)))
                    .about(cursor.getString(cursor.getColumnIndex(COLUMN_ABOUT)))
                    .build();

            return extras;
        } else {
            return null;
        }
    }

    @Override
    public Extras save(Extras entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_EVENT_CALENDER, entity.getEvent_Calender().toString());
        values.put(COLUMN_WEATHER, entity.getWeather());
        values.put(COLUMN_SUGGESTION_BOX, entity.getSuggestion_Box());
        values.put(COLUMN_AUDIOVISUALS, entity.getAudioVisuals());
        values.put(COLUMN_ABOUT, entity.getAbout());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Extras insertedEntity = new Extras.Builder()
                .copyObj(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public Extras update(Extras entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_EVENT_CALENDER, entity.getEvent_Calender().toString());
        values.put(COLUMN_WEATHER, entity.getWeather());
        values.put(COLUMN_SUGGESTION_BOX, entity.getSuggestion_Box());
        values.put(COLUMN_AUDIOVISUALS, entity.getAudioVisuals());
        values.put(COLUMN_ABOUT, entity.getAbout());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }
    @Override
    public Extras delete(Extras entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Extras> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<Extras> extrasSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Extras extras = new Extras.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .event_Calender(cursor.getString(cursor.getColumnIndex(COLUMN_EVENT_CALENDER)))
                        .weather(cursor.getString(cursor.getColumnIndex(COLUMN_WEATHER)))
                        .suggestion_Box(cursor.getString(cursor.getColumnIndex(COLUMN_SUGGESTION_BOX)))
                        .audioVisuals(cursor.getString(cursor.getColumnIndex(COLUMN_AUDIOVISUALS)))
                        .about(cursor.getString(cursor.getColumnIndex(COLUMN_ABOUT)))
                        .build();
                 extrasSet.add(extras);
            } while (cursor.moveToNext());
        }
        return extrasSet;
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