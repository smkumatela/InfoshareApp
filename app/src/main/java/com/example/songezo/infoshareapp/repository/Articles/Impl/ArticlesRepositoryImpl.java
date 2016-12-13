package com.example.songezo.infoshareapp.repository.Articles.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.conf.databases.DBConstants;
import com.example.songezo.infoshareapp.conf.util.AppUtil;
import com.example.songezo.infoshareapp.domain.Articles;
import com.example.songezo.infoshareapp.repository.Articles.ArticlesRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by VERNON on 2016/12/12.
 */
public class ArticlesRepositoryImpl extends SQLiteOpenHelper implements ArticlesRepository {

    public static final String TABLE_NAME = "about";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "about_id";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TOPIC = "topic";
    public static final String COLUMN_CATEGORY = "category";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DATE + " DATE NOT NULL, "
            + COLUMN_NAME + " TEXT NOT NULL, "
            + COLUMN_TOPIC + " TEXT NOT NULL, "
            + COLUMN_CATEGORY + " TEXT NOT NULL );";


    public ArticlesRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }



    @Override
    public Articles findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_DATE,
                        COLUMN_NAME,
                        COLUMN_TOPIC,
                        COLUMN_CATEGORY},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Articles articles = new Articles.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .date(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE))))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .topic(cursor.getString(cursor.getColumnIndex(COLUMN_TOPIC)))
                    .category(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)))
                    .build();

            return articles;
        } else {
            return null;
        }
    }


    @Override
    public Articles save(Articles entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_DATE, entity.getDate().toString());
        values.put(COLUMN_NAME, entity.getName().toString());
        values.put(COLUMN_TOPIC, entity.getTopic().toString());
        values.put(COLUMN_CATEGORY, entity.getCategory().toString());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Articles insertedEntity = new Articles.Builder()
                .copyObj(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public Articles update(Articles entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_DATE, entity.getDate().toString());
        values.put(COLUMN_NAME, entity.getName().toString());
        values.put(COLUMN_TOPIC, entity.getTopic().toString());
        values.put(COLUMN_CATEGORY, entity.getCategory().toString());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Articles delete(Articles entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Articles> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<Articles> articlesSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Articles articles = new Articles.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .date(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE))))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .topic(cursor.getString(cursor.getColumnIndex(COLUMN_TOPIC)))
                        .category(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)))
                        .build();
                articlesSet.add(articles);
            } while (cursor.moveToNext());
        }
        return articlesSet;
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
