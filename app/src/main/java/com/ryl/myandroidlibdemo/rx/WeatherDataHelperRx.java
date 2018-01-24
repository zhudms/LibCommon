package com.ryl.myandroidlibdemo.rx;

import android.content.Context;

import com.ryl.myandroidlibdemo.MyApplication;
import com.ryl.myandroidlibdemo.bean.WeatherSupportProvince;
import com.ryl.myandroidlibdemo.datahelper.ResponseLisener;
import com.ryl.myandroidlibdemo.util.NetUtil;

import io.reactivex.Observable;

/**
 * Created by rongyile on 2017/12/28.
 */

public class WeatherDataHelperRx {

    public static void getWeatherProvinces(Context context, final ResponseLisener<WeatherSupportProvince> lisener) {

        Observable<WeatherSupportProvince> observable;
        //判断数据源
        if (NetUtil.isNetworkUseful(context)) {
//            WeatherService.getWeatherProvince(context, key, lisener);
//            HttpService.getSupportProvince(MyApplication.keys, new RetrofitCallBackImplent<WeatherSupportProvince>(lisener));
            observable =ObserableHelper.getWeatherNetProvinceObserable(MyApplication.keys);
        } else {
//            getLocalData(lisener);
//            observable=ObserableHelper.getWeatherDBProvinceObserable(MyApplication.keys);
        }

//        observable.subscribe(new Consumer<WeatherSupportProvince>() {
//            @Override
//            public void accept(WeatherSupportProvince weatherSupportProvince) throws Exception {
//                lisener.onSuccess(weatherSupportProvince);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//
//            }
//        }, new Consumer<>() {
//            @Override
//            public void accept(Object o) throws Exception {
//
//            }
//        });

//        Observable<WeatherSupportProvince> observableNet=ObserableHelper.getWeatherNetProvinceObserable(MyApplication.keys);
//        Observable<WeatherSupportProvince> observableDB=ObserableHelper.getWeatherDBProvinceObserable(MyApplication.keys);
//
//        Observable.concat(observableNet,observableDB).firstOrError().subscribe(new Consumer<WeatherSupportProvince>() {
//            @Override
//            public void accept(WeatherSupportProvince weatherSupportProvince) throws Exception {
//                lisener.onSuccess(weatherSupportProvince);
//            }
//        });
    }


    public static void getLocalData(ResponseLisener lisener) {
        lisener.onDBSuccess(new WeatherSupportProvince());
    }
}
