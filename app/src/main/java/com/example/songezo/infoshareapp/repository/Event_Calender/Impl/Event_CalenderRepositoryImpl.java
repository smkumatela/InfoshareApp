package com.example.songezo.infoshareapp.repository.Event_Calender.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.conf.databases.DBConstants;
import com.example.songezo.infoshareapp.domain.Event_Calender;
import com.example.songezo.infoshareapp.repository.Event_Calender.Event_CalenderRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mandisi on 12/13/2016.
 */

public class Event_CalenderRepositoryImpl extends SQLiteOpenHelper implements Event_CalenderRepository {

    public static final String TABLE_NAME = "event_Calender";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "event_Calender_id";
    public static final String COLUMN_ORGANIZATION = "event_Calender_organization";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_ORGANIZATION + " TEXT NOT NULL );";


    public Event_CalenderRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }


    @Override
    public Event_Calender findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_ORGANIZATION},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Event_Calender event_Calender = new Event_Calender.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .organization(cursor.getString(cursor.getColumnIndex(COLUMN_ORGANIZATION)))
                    .build();

            return event_Calender;
        } else {
            return null;
        }
    }

    @Override
    public Event_Calender save(Event_Calender entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ORGANIZATION, entity.getOrganization().toString());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Event_Calender insertedEntity = new Event_Calender.Builder()
                .copyObj(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public Event_Calender update(Event_Calender entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ORGANIZATION, entity.getOrganization().toString());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Event_Calender delete(Event_Calender entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Event_Calender> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<Event_Calender> event_CalendersSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Event_Calender event_Calender = new Event_Calender.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .organization(cursor.getString(cursor.getColumnIndex(COLUMN_ORGANIZATION)))
                        .build();
                event_CalendersSet.add(event_Calender);
            } while (cursor.moveToNext());
        }
        return event_CalendersSet;
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
