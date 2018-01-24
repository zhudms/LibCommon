package com.ryl.myandroidlibdemo.rx;

import com.ryl.myandroidlibdemo.datahelper.ResponseLisener;

import io.reactivex.functions.Function;

/**
 * 数据脱壳
 * Created by rongyile on 2018/1/4.
 */

public class RYLFunction<T extends RetrofitResultParentBRx,R> implements Function<T,R> {

    private ResponseLisener lisener;

    public RYLFunction(ResponseLisener lisener) {
        this.lisener = lisener;
    }

    @Override
    public R apply(T t) throws Exception {
        if (t.getFLAG()==RetrofitResultParentBRx.REQUEST_SUCCESS_DEFAULT){
            return ((R) t.getRealResult());
        }else{
            lisener.onFail(t.getError_code());
            return null;
        }


    }


}
