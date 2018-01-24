package com.ryl.myandroidlibdemo.net;


import com.ryl.myandroidlibdemo.MyApplication;
import com.ryl.myandroidlibdemo.bean.WeatherSupportProvince;
import com.ryl.myandroidlibdemo.retrofittemp.RetrofitCallBackCoreImplent;

import retrofit2.Call;

/**
 * 发起请求
 * Created by TANG on 2016/5/12.
 */
public class HttpService {



    public static  Call<WeatherSupportProvince> getSupportProvince(String key, RetrofitCallBackCoreImplent callBack) {

        Call<WeatherSupportProvince> call = MyApplication.mHttp.getSupportProvince(key);
                call.enqueue(callBack);

        return call;

//       return  MyHttpService.getSupportProvince(key);

//      Call<WeatherSupportProvince> call=  MyHttpService.getSupportProvince(key);
//      call.cancel();
//        }

    }
}
