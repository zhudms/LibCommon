package com.ryl.myandroidlibdemo.bean;

import java.util.ArrayList;

/**
 * Created by TANG on 2016/4/26.
 */
public class ResultBeans<T> extends RetrofitResultParentB {
    private static final long serialVersionUID = -2034353245618949629L;
    public ArrayList<T> INFO;

    public ArrayList<T> getINFO() {
        return INFO;
    }

    public void setINFO(ArrayList<T> INFO) {
        this.INFO = INFO;
    }

    @Override
    public Object getRealData() {
        return getINFO();
    }
}
