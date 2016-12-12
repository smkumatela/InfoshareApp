package com.example.songezo.infoshareapp.repository.medicalHistory.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.conf.util.AppUtil;
import com.example.songezo.infoshareapp.domain.MedicalHistory;
import com.example.songezo.infoshareapp.repository.medicalHistory.MedicalHistoryRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Songezo on 2016-12-12.
 */
public class MedicalHistoryRepositoryImpl extends SQLiteOpenHelper implements MedicalHistoryRepository {

    public static final String TABLE_NAME = "medical_History";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_COMMENTS = "comments";
    public static final String COLUMN_TASK = "task";

    private static final String DATABASE_CREATE = "CREATE TABLE"
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DATE + " TEXT NOT NULL, "
            + COLUMN_COMMENTS + "TEXT NOT NULL, "
            + COLUMN_TASK + "TEXT NOT NULL );";

    public MedicalHistoryRepositoryImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void open() throws SQLException {
        db = this.getReadableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public MedicalHistory findById(Long aLong) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_DATE,
                        COLUMN_COMMENTS,
                        COLUMN_TASK
                },
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(aLong)},
                null,
                null,
                null);
        if (cursor.moveToFirst()){
            final MedicalHistory medicalHistory = new MedicalHistory.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .task(cursor.getString(cursor.getColumnIndex(COLUMN_TASK)))
                    .comments(cursor.getString(cursor.getColumnIndex(COLUMN_COMMENTS)))
                    .date(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE))))
                    .build();
            return medicalHistory;
        } else {
            return null;
        }
    }

    @Override
    public MedicalHistory save(MedicalHistory entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_COMMENTS, entity.getComments().toString());
        values.put(COLUMN_TASK, entity.getTask().toString());
        values.put(COLUMN_DATE, entity.getDate().toString());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        MedicalHistory InsertedEntity = new MedicalHistory.Builder()
                        .copyObj(entity)
                        .id(id)
                        .build();
        return InsertedEntity;
    }

    @Override
    public MedicalHistory update(MedicalHistory entity) {
        open();
        ContentValues values =  new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_COMMENTS, entity.getComments());
        values.put(COLUMN_TASK, entity.getTask());
        values.put(COLUMN_DATE, entity.getDate().toString());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public MedicalHistory delete(MedicalHistory entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Set<MedicalHistory> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<MedicalHistory> medicalHistorySet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                final MedicalHistory medicalHistory = new MedicalHistory.Builder()
                                  .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                                  .date(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE))))
                                  .comments(cursor.getString(cursor.getColumnIndex(COLUMN_COMMENTS)))
                                  .task(cursor.getString(cursor.getColumnIndex(COLUMN_TASK)))
                                  .build();
                        medicalHistorySet.add(medicalHistory);
            }   while (cursor.moveToNext());
        }
        return medicalHistorySet;
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
