package com.ryl.myandroidlibdemo.datahelper;

/**
 * Created by rongyile on 2017/12/25.
 */

public interface ResponseLisener<T> {

    void onNetSuccess(T o);

    void onDBSuccess(T o);

    void onFail(Object o);
}
