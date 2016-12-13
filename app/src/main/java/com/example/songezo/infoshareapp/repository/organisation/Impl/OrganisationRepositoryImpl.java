package com.example.songezo.infoshareapp.repository.organisation.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.conf.databases.DBConstants;
import com.example.songezo.infoshareapp.domain.Organisation;
import com.example.songezo.infoshareapp.repository.organisation.OrganisationRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/11.
 */

public class OrganisationRepositoryImpl extends SQLiteOpenHelper implements OrganisationRepository {

    public static final String TABLE_NAME = "organisation";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "organisation_id";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT );";


    public OrganisationRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }


    @Override
    public Organisation findById(Long id) {
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
            final Organisation organisation = new Organisation.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .build();

            return organisation;
        } else {
            return null;
        }
    }

    @Override
    public Organisation save(Organisation entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Organisation insertedEntity = new Organisation.Builder()
                .copyObj(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public Organisation update(Organisation entity) {

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
    public Organisation delete(Organisation entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Organisation> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<Organisation> organisationSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Organisation login = new Organisation.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .build();
                organisationSet.add(login);
            } while (cursor.moveToNext());
        }
        return organisationSet;
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



