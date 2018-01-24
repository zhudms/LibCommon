//package com.ryl.myandroidlibdemo.net;
//
//import android.content.Context;
//
//import com.ryl.myandroidlibdemo.bean.WeatherSupportProvince;
//import com.ryl.myandroidlibdemo.net.HttpService;
//import com.ryl.myandroidlibdemo.datahelper.ResponseLisener;
//import com.ryl.myandroidlibdemo.retrofittemp.RetrofitCallBackImplent;
//import com.ryl.myandroidlibdemo.util.NetUtil;
//
//import java.util.ArrayList;
//
///**
// * 按功能分
// * Created by rongyile on 2017/12/22.
// */
//
//public class WeatherService {
//
//    public static void getWeatherProvince(Context context, String key,  ResponseLisener lisener) {
//
////        网络
//        if (NetUtil.isNetworkUseful(context)) {
//            HttpService.getSupportProvince(key, new RetrofitCallBackImplent<WeatherSupportProvince>(lisener));
//        }
//
//        //DB
//
////        return new WeatherSupportProvince();
//    }
//}
