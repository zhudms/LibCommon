package com.ryl.myandroidlibdemo.bean;

import io.reactivex.disposables.Disposable;

/**
 * Created by rongyile on 2018/1/26.
 */

public class HttpCancelBean {
    private String tag;
    private Disposable disposable;


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Disposable getDisposable() {
        return disposable;
    }

    public void setDisposable(Disposable disposable) {
        this.disposable = disposable;
    }

    public HttpCancelBean(String tag, Disposable disposable) {

        this.tag = tag;
        this.disposable = disposable;
    }
}
