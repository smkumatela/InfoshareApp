package com.example.songezo.infoshareapp.repository.AudioVisuals.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.conf.databases.DBConstants;
import com.example.songezo.infoshareapp.domain.AudioVisuals;
import com.example.songezo.infoshareapp.repository.AudioVisuals.AudioVisualsRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by VERNON on 2016/12/12.
 */
public class AudioVisualsImpl extends SQLiteOpenHelper implements AudioVisualsRepository {

    public static final String TABLE_NAME = "audioVisuals";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "login_id";
    public static final String COLUMN_AUDIO = "audio";
    public static final String COLUMN_VIDEO = "video";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_AUDIO + " TEXT NOT NULL, "
            + COLUMN_VIDEO + " TEXT NOT NULL );";


    public AudioVisualsImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }



    @Override
    public AudioVisuals findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_AUDIO,
                        COLUMN_VIDEO},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final AudioVisuals audio = new AudioVisuals.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .aud(cursor.getString(cursor.getColumnIndex(COLUMN_AUDIO)))
                    .vid(cursor.getString(cursor.getColumnIndex(COLUMN_VIDEO)))
                    .build();

            return audio;
        } else {
            return null;
        }
    }


    @Override
    public AudioVisuals save(AudioVisuals entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_AUDIO, entity.getAudio().toString());
        values.put(COLUMN_VIDEO, entity.getVideo().toString());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        AudioVisuals insertedEntity = new AudioVisuals.Builder()
                .copyObj(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public AudioVisuals update(AudioVisuals entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_AUDIO, entity.getAudio().toString());
        values.put(COLUMN_VIDEO, entity.getVideo().toString());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public AudioVisuals delete(AudioVisuals entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<AudioVisuals> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<AudioVisuals> audioSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final AudioVisuals audio = new AudioVisuals.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .aud(cursor.getString(cursor.getColumnIndex(COLUMN_AUDIO)))
                        .vid(cursor.getString(cursor.getColumnIndex(COLUMN_VIDEO)))
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
