package com.ryl.myandroidlibdemo.base;

import com.ryl.myandroidlibdemo.datahelper.ResponseLisener;

/**
 * Created by rongyile on 2018/1/26.
 */

public abstract class ManageableResponseLisner<T> implements ResponseLisener<T> {
    private String tag;

    public ManageableResponseLisner(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
