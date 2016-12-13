package com.example.songezo.infoshareapp.repository.messagingcontacts.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.conf.databases.DBConstants;
import com.example.songezo.infoshareapp.domain.MessagingContacts;
import com.example.songezo.infoshareapp.repository.messagingcontacts.MessagingContactsRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/11.
 */

public class MessagingContactsRepositoryImpl extends SQLiteOpenHelper implements MessagingContactsRepository {

    public static final String TABLE_NAME = "messagingcontacts";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "messagingcontacts_id";
    public static final String COLUMN_CAREGIVER = "messagingcontacts_caregiver";
    public static final String COLUMN_ORGANISATION = "messagingcontacts_organisation";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CAREGIVER + " TEXT NOT NULL , "
            + COLUMN_ORGANISATION + " TEXT NOT NULL );";


    public MessagingContactsRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public MessagingContacts findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_CAREGIVER,
                        COLUMN_ORGANISATION},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final MessagingContacts messagingContacts = new MessagingContacts.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .caregiver(cursor.getString(cursor.getColumnIndex(COLUMN_CAREGIVER)))
                    .organisation(cursor.getString(cursor.getColumnIndex(COLUMN_ORGANISATION)))
                    .build();

            return messagingContacts;
        } else {
            return null;
        }
    }

    @Override
    public MessagingContacts save(MessagingContacts entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CAREGIVER, entity.getCaregiver().toString());
        values.put(COLUMN_ORGANISATION, entity.getOrganisation());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        MessagingContacts insertedEntity = new MessagingContacts.Builder()
                .copyObj(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public MessagingContacts update(MessagingContacts entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CAREGIVER, entity.getCaregiver().toString());
        values.put(COLUMN_ORGANISATION, entity.getOrganisation());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public MessagingContacts delete(MessagingContacts entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<MessagingContacts> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<MessagingContacts> messagingContactsSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final MessagingContacts login = new MessagingContacts.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .caregiver(cursor.getString(cursor.getColumnIndex(COLUMN_CAREGIVER)))
                        .organisation(cursor.getString(cursor.getColumnIndex(COLUMN_ORGANISATION)))
                        .build();
                messagingContactsSet.add(login);
            } while (cursor.moveToNext());
        }
        return messagingContactsSet;
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
