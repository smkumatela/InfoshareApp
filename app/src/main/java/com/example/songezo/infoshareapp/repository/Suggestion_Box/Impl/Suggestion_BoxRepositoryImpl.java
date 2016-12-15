package com.example.songezo.infoshareapp.repository.Suggestion_Box.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.conf.databases.DBConstants;
import com.example.songezo.infoshareapp.domain.Suggestion_Box;
import com.example.songezo.infoshareapp.repository.Suggestion_Box.Suggestion_BoxRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mandisi on 12/13/2016.
 */

public class Suggestion_BoxRepositoryImpl extends SQLiteOpenHelper implements Suggestion_BoxRepository {

    public static final String TABLE_NAME = "suggestion_Box";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "suggestion_Box_id";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT );";


    public Suggestion_BoxRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }


    @Override
    public Suggestion_Box findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Suggestion_Box suggestion_Box = new Suggestion_Box.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .build();

            return suggestion_Box;
        } else {
            return null;
        }
    }

    @Override
    public Suggestion_Box save(Suggestion_Box entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Suggestion_Box insertedEntity = new Suggestion_Box.Builder()
                .copyObj(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public Suggestion_Box update(Suggestion_Box entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Suggestion_Box delete(Suggestion_Box entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Suggestion_Box> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<Suggestion_Box> suggestion_BoxSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Suggestion_Box suggestion_Box = new Suggestion_Box.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .build();
                suggestion_BoxSet.add(suggestion_Box);
            } while (cursor.moveToNext());
        }
        return suggestion_BoxSet;
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