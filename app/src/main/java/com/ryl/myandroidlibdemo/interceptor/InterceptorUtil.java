package com.ryl.myandroidlibdemo.interceptor;

import com.ryl.myandroidlibdemo.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.ryl.myandroidlibdemo.util.ConstantUtil.FILE_TIME_OUT;

/**
 * Created by rongyile on 2017/12/22.
 */

public class InterceptorUtil {

    public Retrofit.Builder getFileRetrofit(Retrofit.Builder builder, Interceptor interceptor) {

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .connectTimeout(FILE_TIME_OUT, TimeUnit.SECONDS)//设置超时时间
                .retryOnConnectionFailure(true);

        client.addInterceptor(interceptor);

        return builder.client(client.build());

    }
}
