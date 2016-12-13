package com.example.songezo.infoshareapp.repository.About.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.conf.databases.DBConstants;
import com.example.songezo.infoshareapp.domain.About;
import com.example.songezo.infoshareapp.repository.About.AboutRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by VERNON on 2016/12/12.
 */
public class AboutRepositoryImpl extends SQLiteOpenHelper implements AboutRepository {

    public static final String TABLE_NAME = "about";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "about_id";
    public static final String COLUMN_ABOUTINFOSHARE = "aboutInfoshare";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_ABOUTINFOSHARE + " TEXT NOT NULL );";


    public AboutRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }



    @Override
    public About findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_ABOUTINFOSHARE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final About about = new About.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .aboutInfoshare(cursor.getString(cursor.getColumnIndex(COLUMN_ABOUTINFOSHARE)))
                    .build();

            return about;
        } else {
            return null;
        }
    }


    @Override
    public About save(About entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ABOUTINFOSHARE, entity.getAboutInfoshare().toString());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        About insertedEntity = new About.Builder()
                .copyObj(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public About update(About entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ABOUTINFOSHARE, entity.getAboutInfoshare().toString());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public About delete(About entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<About> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<About> aboutSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final About about = new About.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .aboutInfoshare(cursor.getString(cursor.getColumnIndex(COLUMN_ABOUTINFOSHARE)))
                        .build();
                aboutSet.add(about);
            } while (cursor.moveToNext());
        }
        return aboutSet;
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
