package com.example.praktek.externdb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseHelper extends SQLiteAssetHelper {
    private static String dbname = "login.db";

    public DatabaseHelper(Context context) {
        super(context, dbname, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
}