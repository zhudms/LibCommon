package com.ryl.myandroidlibdemo.rx;

import com.ryl.myandroidlibdemo.bean.RetrofitResultParentB;
import com.ryl.myandroidlibdemo.testbean.Provinces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rongyile on 2017/12/21.
 */
public class WeatherSupportProvinceRx<T> extends RetrofitResultParentBRx{

    private static final long serialVersionUID = -1177538206193901101L;


    private String reason;
    private ArrayList<T> result;


    public String getReason() {
        return reason;
    }

    public ArrayList<T> getResult() {
        return result;
    }


    public List<T> getRealData(){
        return result;
    }

    @Override
    public Object getRealResult() {
        return result;
    }
}
