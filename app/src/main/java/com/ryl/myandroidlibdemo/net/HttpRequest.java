package com.ryl.myandroidlibdemo.net;


import com.ryl.myandroidlibdemo.bean.WeatherSupportProvince;
import com.ryl.myandroidlibdemo.rx.WeatherSupportProvinceRx;
import com.ryl.myandroidlibdemo.testbean.Provinces;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 全部Http请求的接口都在这
 * 分不同方法
 * Created by TANG on 2016/3/12.
 */
public interface HttpRequest {


    @GET("historyWeather/province")
//    Observable<WeatherSupportProvince> getSupportProvince(@Query("key") String key);
    Call<WeatherSupportProvince> getSupportProvince(@Query("key") String key);


    @GET("historyWeather/province")
    Observable<WeatherSupportProvince> getSupportProvinceObserable(@Query("key") String key);


 @GET("historyWeather/province")
    Observable<WeatherSupportProvinceRx<Provinces>> getSupportProvinceObserableRx(@Query("key") String key);
}