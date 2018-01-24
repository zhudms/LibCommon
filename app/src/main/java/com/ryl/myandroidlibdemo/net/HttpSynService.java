package com.ryl.myandroidlibdemo.net;

import com.ryl.myandroidlibdemo.MyApplication;
import com.ryl.myandroidlibdemo.bean.WeatherSupportProvince;
import com.ryl.myandroidlibdemo.datahelper.ResponseLisener;
import com.ryl.myandroidlibdemo.retrofittemp.RetrofitCallBackCoreImplent;
import com.ryl.myandroidlibdemo.testbean.Provinces;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by rongyile on 2017/12/21.
 */

public class HttpSynService {

    public static ExecutorService netPool = Executors.newSingleThreadExecutor();

    public static Call<WeatherSupportProvince> getSupportProvince(final String key, final RetrofitCallBackCoreImplent lisener) {

        final Call<WeatherSupportProvince> call = MyApplication.mHttp.getSupportProvince(key);

        netPool.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    Response<WeatherSupportProvince> provinces = call.execute();
                    if (provinces.isSuccessful()) {
                        lisener.onResponse(null, provinces);

//                        lisener.onNetSuccess(provinces.body().getResult());
                    } else {
//                        lisener.onFail(provinces.errorBody());
                        lisener.onFailure(provinces.errorBody().toString());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    lisener.onFailure(e.toString());
                }
            }
        });

        return call;
    }

    public static Call<WeatherSupportProvince> getSupportProvince(final String key, final  ResponseLisener<List<Provinces>> lisener) {

        final Call<WeatherSupportProvince> call = MyApplication.mHttp.getSupportProvince(key);

        netPool.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    Response<WeatherSupportProvince> provinces = call.execute();
                    if (provinces.isSuccessful()) {
                        lisener.onNetSuccess(provinces.body().getResult());

//                        lisener.onNetSuccess(provinces.body().getResult());
                    } else {
//                        lisener.onFail(provinces.errorBody());
                        lisener.onFail(provinces.errorBody().toString());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    lisener.onFail(e.toString());
                }
            }
        });

        return call;
    }

}
