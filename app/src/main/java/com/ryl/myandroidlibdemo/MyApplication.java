package com.ryl.myandroidlibdemo;

import android.app.Application;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.ryl.eventbuslib.EventBusHelper;
import com.ryl.eventbuslib.bean.InitHttpFinish;
import com.ryl.myandroidlibdemo.net.ClientAPI;
import com.ryl.myandroidlibdemo.net.HttpRequest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by rongyile on 2017/12/19.
 */

public class MyApplication extends Application {

    public static final boolean isDebug=true;
    public static final String DB_NAME = "";

    public static final String keys = "2c390f0ff5ffdac9da10f7bbcff2069f";


    public static HttpRequest mHttp;

    @Override
    public void onCreate() {
        super.onCreate();
        initHttp();
    }


    public static void initHttp() {
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(ClientAPI.BASE_HTTP)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mHttp = restAdapter.create(HttpRequest.class);
        EventBusHelper.post(new InitHttpFinish());
    }


}

