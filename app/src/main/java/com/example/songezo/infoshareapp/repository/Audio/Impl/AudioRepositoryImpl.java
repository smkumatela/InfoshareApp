package com.example.songezo.infoshareapp.repository.Audio.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.conf.databases.DBConstants;
import com.example.songezo.infoshareapp.domain.Audio;
import com.example.songezo.infoshareapp.repository.Audio.AudioRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by VERNON on 2016/12/12.
 */
public class AudioRepositoryImpl extends SQLiteOpenHelper implements AudioRepository {

    public static final String TABLE_NAME = "audio";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "audio_id";
    public static final String COLUMN_AUDIONAME = "audioName";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_AUDIONAME + " TEXT NOT NULL );";


    public AudioRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }



    @Override
    public Audio findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_AUDIONAME},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Audio audio = new Audio.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .audioName(cursor.getString(cursor.getColumnIndex(COLUMN_AUDIONAME)))
                    .build();

            return audio;
        } else {
            return null;
        }
    }


    @Override
    public Audio save(Audio entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_AUDIONAME, entity.getAudioName().toString());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Audio insertedEntity = new Audio.Builder()
                .copyObj(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public Audio update(Audio entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_AUDIONAME, entity.getAudioName().toString());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Audio delete(Audio entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Audio> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<Audio> audioSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Audio audio = new Audio.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .audioName(cursor.getString(cursor.getColumnIndex(COLUMN_AUDIONAME)))
                        .build();
                audioSet.add(audio);
            } while (cursor.moveToNext());
        }
        return audioSet;
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
