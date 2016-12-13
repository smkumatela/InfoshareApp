package com.example.songezo.infoshareapp.repository.myPatient.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.conf.databases.DBConstants;
import com.example.songezo.infoshareapp.conf.util.AppUtil;
import com.example.songezo.infoshareapp.domain.MyPatient;
import com.example.songezo.infoshareapp.repository.myPatient.MyPatientRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Songezo on 2016-12-13.
 */
public class MyPatientRepositoryImpl extends SQLiteOpenHelper implements MyPatientRepository {

    public static final String TABLE_NAME = "my_Patient";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE = "pDate";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_NAME = "name";

    private static final String DATABASE_CREATE = "CREATE TABLE"
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DATE + " TEXT NOT NULL, "
            + COLUMN_TIME + "TIME NOT NULL, "
            + COLUMN_NAME + "TEXT NOT NULL, "
            + COLUMN_LOCATION + "TEXT NOT NULL );";

    public MyPatientRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getReadableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public MyPatient findById(Long aLong) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_DATE,
                        COLUMN_TIME,
                        COLUMN_NAME,
                        COLUMN_LOCATION
                },
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(aLong)},
                null,
                null,
                null);
        if (cursor.moveToFirst()){
            final MyPatient myPatient = new MyPatient.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .location(cursor.getString(cursor.getColumnIndex(COLUMN_LOCATION)))
                    .pDate(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE))))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .build();
            return myPatient;
        } else {
            return null;
        }
    }

    @Override
    public MyPatient save(MyPatient entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_LOCATION, entity.getLocation());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_DATE, entity.getpDate().toString());
        values.put(COLUMN_TIME, entity.getTime().toString());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        MyPatient InsertedEntity = new MyPatient.Builder()
                .copyObj(entity)
                .id(id)
                .build();
        return InsertedEntity;
    }

    @Override
    public MyPatient update(MyPatient entity) {
        open();
        ContentValues values =  new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_LOCATION, entity.getLocation());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_DATE, entity.getpDate().toString());
        values.put(COLUMN_TIME, entity.getTime().toString());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public MyPatient delete(MyPatient entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Set<MyPatient> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<MyPatient> myPatientHashSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                final MyPatient myPatient = new MyPatient.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .location(cursor.getString(cursor.getColumnIndex(COLUMN_LOCATION)))
                        .pDate(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE))))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .build();
                myPatientHashSet.add(myPatient);
            }   while (cursor.moveToNext());
        }
        return myPatientHashSet;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME, null, null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", wgich will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
