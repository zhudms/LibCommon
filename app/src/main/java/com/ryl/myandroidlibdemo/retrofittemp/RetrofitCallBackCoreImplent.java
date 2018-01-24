package com.ryl.myandroidlibdemo.retrofittemp;

import com.ryl.myandroidlibdemo.bean.RetrofitResultParentB;
import com.ryl.myandroidlibdemo.datahelper.NetResultLisener;

import retrofit2.Call;
import retrofit2.Response;

/**
 * 统一处理一次网络请求,主要处理失败的各种情况,弹提示等
 * Created by rongyile on 2017/12/22.
 */

public class RetrofitCallBackCoreImplent<T> implements RetrofitCallBackCore<RetrofitResultParentB> {


    private NetResultLisener mLisener;

    public RetrofitCallBackCoreImplent(NetResultLisener mLisener) {
        this.mLisener = mLisener;
    }

    @Override
    public void onResponse(Call<RetrofitResultParentB> call, Response<RetrofitResultParentB> response) {

        if (response.errorBody() == null) {

            this.mLisener.onSuccess(response.body());
        } else {
            this.mLisener.onFail(response.errorBody());
        }

    }

    @Override
    public void onFailure(Call<RetrofitResultParentB> call, Throwable t) {

        this.mLisener.onFail(t.toString());

    }

    public void onFailure(String errorMessage){}
}
