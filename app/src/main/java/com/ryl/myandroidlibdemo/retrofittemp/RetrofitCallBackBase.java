package com.ryl.myandroidlibdemo.retrofittemp;

import com.ryl.myandroidlibdemo.bean.RetrofitResultParentB;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rongyile on 2017/12/22.
 */

public interface RetrofitCallBackBase<T> extends Callback<T> {

    @Override
    void onResponse(Call<T> call, Response<T> response);

    @Override
    void onFailure(Call<T> call, Throwable t);


}



