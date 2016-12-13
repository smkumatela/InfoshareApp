package com.example.songezo.infoshareapp.repository.mainmenu.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.conf.databases.DBConstants;
import com.example.songezo.infoshareapp.domain.MainMenu;
import com.example.songezo.infoshareapp.repository.mainmenu.MainMenuRepository;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by asiphe.dyani on 2016/12/11.
 */

public class MainMenuRepositoryImpl extends SQLiteOpenHelper implements MainMenuRepository {


    public static final String TABLE_NAME = "mainmenu";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "mainmenu_id";
    public static final String COLUMN_MYPATIENT = "mainmenu_patient";
    public static final String COLUMN_STORIES = "mainmenu_stories";
    public static final String COLUMN_MESSAGINGCONTACTS = "mainmenu_messagingcontacts";
    public static final String COLUMN_SEESTORIES = "mainmenu_seestories";
    public static final String COLUMN_EXTRAS = "mainmenu_extras";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_MYPATIENT + " TEXT NOT NULL , "
            + COLUMN_STORIES + " TEXT NOT NULL , "
            + COLUMN_MESSAGINGCONTACTS + " TEXT NOT NULL , "
            + COLUMN_SEESTORIES + " TEXT NOT NULL , "
            + COLUMN_EXTRAS + " TEXT NOT NULL );";


    public MainMenuRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }


    @Override
    public MainMenu findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_MYPATIENT,
                        COLUMN_STORIES,
                        COLUMN_MESSAGINGCONTACTS,
                        COLUMN_SEESTORIES,
                        COLUMN_EXTRAS},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final MainMenu mainMenu = new MainMenu.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .myPatient(cursor.getString(cursor.getColumnIndex(COLUMN_MYPATIENT)))
                    .stories(cursor.getString(cursor.getColumnIndex(COLUMN_STORIES)))
                    .messagingContacts(cursor.getString(cursor.getColumnIndex(COLUMN_MESSAGINGCONTACTS)))
                    .seeStories(cursor.getString(cursor.getColumnIndex(COLUMN_SEESTORIES)))
                    .extras(cursor.getString(cursor.getColumnIndex(COLUMN_EXTRAS)))
                    .build();

            return mainMenu;
        } else {
            return null;
        }
    }

    @Override
    public MainMenu save(MainMenu entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_MYPATIENT, entity.getMyPatient().toString());
        values.put(COLUMN_STORIES, entity.getStories());
        values.put(COLUMN_MESSAGINGCONTACTS, entity.getMessagingContacts());
        values.put(COLUMN_SEESTORIES, entity.getSeeStories());
        values.put(COLUMN_EXTRAS, entity.getStories());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        MainMenu insertedEntity = new MainMenu.Builder()
                .copyObj(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public MainMenu update(MainMenu entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_MYPATIENT, entity.getMyPatient().toString());
        values.put(COLUMN_STORIES, entity.getStories());
        values.put(COLUMN_MESSAGINGCONTACTS, entity.getMessagingContacts());
        values.put(COLUMN_SEESTORIES, entity.getSeeStories());
        values.put(COLUMN_EXTRAS, entity.getStories());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public MainMenu delete(MainMenu entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<MainMenu> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<MainMenu> mainMenuSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final MainMenu login = new MainMenu.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .myPatient(cursor.getString(cursor.getColumnIndex(COLUMN_MYPATIENT)))
                        .stories(cursor.getString(cursor.getColumnIndex(COLUMN_STORIES)))
                        .messagingContacts(cursor.getString(cursor.getColumnIndex(COLUMN_MESSAGINGCONTACTS)))
                        .seeStories(cursor.getString(cursor.getColumnIndex(COLUMN_SEESTORIES)))
                        .extras(cursor.getString(cursor.getColumnIndex(COLUMN_EXTRAS)))
                        .build();
                mainMenuSet.add(login);
            } while (cursor.moveToNext());
        }
        return mainMenuSet;
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


