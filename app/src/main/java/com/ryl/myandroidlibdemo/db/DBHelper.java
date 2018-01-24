package com.ryl.myandroidlibdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ryl.myandroidlibdemo.MyApplication;

public class DBHelper extends SQLiteOpenHelper {


    private static int CURRECTVERSION = 1;

    public DBHelper(Context context) {
        super(context, MyApplication.DB_NAME, null, CURRECTVERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }
}