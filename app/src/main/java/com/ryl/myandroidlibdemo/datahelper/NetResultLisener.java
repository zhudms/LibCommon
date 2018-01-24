package com.ryl.myandroidlibdemo.datahelper;

/**
 * Created by rongyile on 2017/12/29.
 */

public interface NetResultLisener<T> {
    void onSuccess(T message);
    void onFail(Object  errorMessage);
}
