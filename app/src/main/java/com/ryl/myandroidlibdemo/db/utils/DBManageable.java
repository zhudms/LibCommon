package com.ryl.myandroidlibdemo.db.utils;

import android.content.Context;

import com.ryl.myandroidlibdemo.datahelper.ResponseLisener;
import com.ryl.myandroidlibdemo.testbean.Provinces;

import java.util.List;

/**
 * Created by rongyile on 2018/1/4.
 */

public interface DBManageable<T> {

    void initDBHelper();

//    void updataDB(Context context,T t);

     T getLocalData(Context context);

}
