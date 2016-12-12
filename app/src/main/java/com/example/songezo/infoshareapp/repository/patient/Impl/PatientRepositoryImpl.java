package com.example.songezo.infoshareapp.repository.patient.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.conf.util.AppUtil;
import com.example.songezo.infoshareapp.domain.Patient;
import com.example.songezo.infoshareapp.repository.patient.PatientRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Songezo on 2016-12-12.
 */
public class PatientRepositoryImpl extends SQLiteOpenHelper implements PatientRepository {

    public static final String TABLE_NAME = "patient";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_REASONFORVISIT = "reasonForVisit";
    public static final String COLUMN_DATEOFBIRTH = "dateOfBirth";
    public static final String COLUMN_LANGUAGE = "language";
    public static final String COLUMN_TELEPHONE = "telephone";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_MEDICALHISTORY = "medicalHistory";
    public static final String COLUMN_TODO = "toDo";

    private static final String DATABASE_CREATE = "CREATE TABLE"
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT NOT NULL, "
            + COLUMN_ADDRESS + "TEXT NOT NULL, "
            + COLUMN_REASONFORVISIT + "TEXT NOT NULL, "
            + COLUMN_DATEOFBIRTH + "DATE NOT NULL, "
            + COLUMN_LANGUAGE + "TEXT NOT NULL, "
            + COLUMN_TELEPHONE + "INTEGER NOT NULL, "
            + COLUMN_GENDER + "TEXT NOT NULL, "
            + COLUMN_MEDICALHISTORY + "TEXT NOT NULL, "
            + COLUMN_TODO + "TEXT NOT NULL );";

    public PatientRepositoryImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void open() throws SQLException {
        db = this.getReadableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Patient findById(Long aLong) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NAME,
                        COLUMN_ADDRESS,
                        COLUMN_REASONFORVISIT,
                        COLUMN_DATEOFBIRTH,
                        COLUMN_LANGUAGE,
                        COLUMN_TELEPHONE,
                        COLUMN_GENDER,
                        COLUMN_MEDICALHISTORY,
                        COLUMN_TODO
                },
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(aLong)},
                null,
                null,
                null);
        if (cursor.moveToFirst()){
            final Patient patient = new Patient.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .address(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)))
                    .reasonForVisit(cursor.getString(cursor.getColumnIndex(COLUMN_REASONFORVISIT)))
                    .date(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATEOFBIRTH))))
                    .language(cursor.getString(cursor.getColumnIndex(COLUMN_LANGUAGE)))
                    .telephone(cursor.getInt(cursor.getColumnIndex(COLUMN_TELEPHONE)))
                    .medicalHistory(cursor.getString(cursor.getColumnIndex(COLUMN_MEDICALHISTORY)))
                    .toDo(cursor.getString(cursor.getColumnIndex(COLUMN_TODO)))
                    .build();
            return patient;
        } else {
            return null;
        }
    }

    @Override
    public Patient save(Patient entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_ADDRESS, entity.getAddress());
        values.put(COLUMN_REASONFORVISIT, entity.getReasonForVisit());
        values.put(COLUMN_DATEOFBIRTH, entity.getDateOfBirth().toString());
        values.put(COLUMN_LANGUAGE, entity.getLanguage());
        values.put(COLUMN_TELEPHONE, entity.getTelephone());
        values.put(COLUMN_GENDER, entity.getGender());
        values.put(COLUMN_MEDICALHISTORY, entity.getMedicalHistory());
        values.put(COLUMN_TODO, entity.getToDo());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Patient InsertedEntity = new Patient.Builder()
                .copyObj(entity)
                .id(id)
                .build();
        return InsertedEntity;
    }

    @Override
    public Patient update(Patient entity) {
        open();
        ContentValues values =  new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_ADDRESS, entity.getAddress());
        values.put(COLUMN_REASONFORVISIT, entity.getReasonForVisit());
        values.put(COLUMN_DATEOFBIRTH, entity.getDateOfBirth().toString());
        values.put(COLUMN_LANGUAGE, entity.getLanguage());
        values.put(COLUMN_TELEPHONE, entity.getTelephone());
        values.put(COLUMN_GENDER, entity.getGender());
        values.put(COLUMN_MEDICALHISTORY, entity.getMedicalHistory());
        values.put(COLUMN_TODO, entity.getToDo());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Patient delete(Patient entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Set<Patient> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Patient> patientHashSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                final Patient medicalHistory = new Patient.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .address(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)))
                        .reasonForVisit(cursor.getString(cursor.getColumnIndex(COLUMN_REASONFORVISIT)))
                        .date(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATEOFBIRTH))))
                        .language(cursor.getString(cursor.getColumnIndex(COLUMN_LANGUAGE)))
                        .telephone(cursor.getInt(cursor.getColumnIndex(COLUMN_TELEPHONE)))
                        .medicalHistory(cursor.getString(cursor.getColumnIndex(COLUMN_MEDICALHISTORY)))
                        .toDo(cursor.getString(cursor.getColumnIndex(COLUMN_TODO)))
                        .build();
                patientHashSet.add(medicalHistory);
            }   while (cursor.moveToNext());
        }
        return patientHashSet;
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
