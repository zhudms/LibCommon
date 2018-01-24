package com.ryl.myandroidlibdemo.bean;

import com.ryl.myandroidlibdemo.testbean.Provinces;

import org.greenrobot.greendao.annotation.Entity;

import java.util.ArrayList;

/**
 * Created by rongyile on 2017/12/21.
 */
public class WeatherSupportProvince extends RetrofitResultParentB{

    private static final long serialVersionUID = -1177538206193901101L;


    private String reason;
    private ArrayList<Provinces> result;


    public String getReason() {
        return reason;
    }

    public ArrayList<Provinces> getResult() {
        return result;
    }


    @Override
    public Object getRealData() {
        return getResult();
    }
}
