package com.example.songezo.infoshareapp.repository.sharestories.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.songezo.infoshareapp.conf.databases.DBConstants;
import com.example.songezo.infoshareapp.domain.ShareStories;
import com.example.songezo.infoshareapp.repository.sharestories.ShareStoriesRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/11.
 */

public class ShareStoriesRepositoryImpl extends SQLiteOpenHelper implements ShareStoriesRepository {

    public static final String TABLE_NAME = "sharestories";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "sharestories_id";
    public static final String COLUMN_SHARE = "sharestories_shared";
    public static final String COLUMN_CLEARED = "sharestories_cleared";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SHARE + " TEXT NOT NULL , "
            + COLUMN_CLEARED + " TEXT NOT NULL );";


    public ShareStoriesRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public ShareStories findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_SHARE,
                        COLUMN_CLEARED},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final ShareStories shareStories = new ShareStories.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .share(cursor.getString(cursor.getColumnIndex(COLUMN_SHARE)))
                    .clear(cursor.getString(cursor.getColumnIndex(COLUMN_CLEARED)))
                    .build();

            return shareStories;
        } else {
            return null;
        }
    }

    @Override
    public ShareStories save(ShareStories entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_SHARE, entity.getShare().toString());
        values.put(COLUMN_CLEARED, entity.getClear());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        ShareStories insertedEntity = new ShareStories.Builder()
                .copyObj(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public ShareStories update(ShareStories entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_SHARE, entity.getShare().toString());
        values.put(COLUMN_CLEARED, entity.getClear());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    @Override
    public ShareStories delete(ShareStories entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<ShareStories> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<ShareStories> shareStoriesSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final ShareStories login = new ShareStories.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .share(cursor.getString(cursor.getColumnIndex(COLUMN_SHARE)))
                        .clear(cursor.getString(cursor.getColumnIndex(COLUMN_CLEARED)))
                        .build();
                shareStoriesSet.add(login);
            } while (cursor.moveToNext());
        }
        return shareStoriesSet;
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
