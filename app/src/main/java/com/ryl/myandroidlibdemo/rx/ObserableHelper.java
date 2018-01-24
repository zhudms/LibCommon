package com.ryl.myandroidlibdemo.rx;


import com.ryl.myandroidlibdemo.MyApplication;
import com.ryl.myandroidlibdemo.bean.WeatherSupportProvince;
import com.ryl.myandroidlibdemo.testbean.Provinces;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rongyile on 2017/12/28.
 */

public class ObserableHelper {

    public static Observable<WeatherSupportProvince> getWeatherNetProvinceObserable(String key) {
        return getCommonObserable(MyApplication.mHttp.getSupportProvinceObserable(key));
    }

    public static Observable<WeatherSupportProvinceRx> getWeatherNetProvinceObserableRx(String key) {
        return getCommonObserable(MyApplication.mHttp.getSupportProvinceObserableRx(key));
    }

    public static Observable<List<Provinces>> getWeatherDBProvinceObserable(String key) {
        return getCommonObserable(MyApplication.mHttp.getSupportProvinceObserable(key));
    }

    public static Observable getCommonObserable(Observable observable) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
