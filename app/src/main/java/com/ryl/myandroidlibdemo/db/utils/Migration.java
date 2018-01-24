package com.ryl.myandroidlibdemo.db.utils;

import android.database.sqlite.SQLiteDatabase;

/**
 */
public interface Migration {

    void migrate(SQLiteDatabase db);

}
