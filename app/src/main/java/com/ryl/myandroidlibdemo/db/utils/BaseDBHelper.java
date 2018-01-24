package com.ryl.myandroidlibdemo.db.utils;

import android.content.Context;

import com.ryl.myandroidlibdemo.datahelper.ResponseLisener;
import com.ryl.myandroidlibdemo.testbean.Provinces;

import java.lang.ref.SoftReference;
import java.util.List;

/**
 * Created by rongyile on 2018/1/4.
 */

public abstract class BaseDBHelper<T, B> {

    protected SoftReference<Context> mContext;

    abstract public boolean updataDB(Context context, T obj);

    abstract public T getLocalData(Context context);

    public void closeDB(B clazz) {
        if (mContext != null && mContext.get() != null) {

            new DaoUtils<B>(mContext.get()).closeDB();
        }

    }

    /**
     * 只有需要关闭数据库的时候才需要赋值(再看这里怎么处理,貌似软引用没有意义)
     * @param context
     */
    public void setmContext(Context context) {

        mContext = new SoftReference<Context>(context);
    }
}
