package com.ryl.myandroidlibdemo.rx;

import com.ryl.myandroidlibdemo.bean.WeatherSupportProvince;
import com.ryl.myandroidlibdemo.datahelper.ResponseLisener;

import io.reactivex.functions.Function;

/**
 * Created by rongyile on 2018/1/23.
 */

public class JHFunction<T extends WeatherSupportProvince, R> implements Function<T, R> {

    private ResponseLisener mLisener;


    public JHFunction(ResponseLisener lisener) {
        this.mLisener = lisener;
    }

    @Override
    public R apply(T t) throws Exception {
        if (t.getReason().contains("成功")) {
            return ((R) t.getResult());
        } else {
            mLisener.onFail(t.getError_code());
            return null;
        }


    }


}
