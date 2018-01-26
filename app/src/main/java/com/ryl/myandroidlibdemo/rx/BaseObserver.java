package com.ryl.myandroidlibdemo.rx;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.ryl.commonlib.tools.StringUtils;
import com.ryl.commonlib.utils.LU;
import com.ryl.myandroidlibdemo.R;
import com.ryl.myandroidlibdemo.datahelper.ResponseLisener;
import com.ryl.myandroidlibdemo.util.NetUtil;

import java.io.IOException;
import java.lang.ref.SoftReference;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by rongyile on 2018/1/3.
 */

public class BaseObserver<T> implements Observer<T> {


    public Disposable mDis;

//    private SoftReference<Context> mSContext;

    public BaseObserver(/*Context mSContext*/) {
//        this.mSContext = new SoftReference<Context>(mSContext);
    }

    @Override
    public void onSubscribe(Disposable d) {
        mDis = d;
        LU.he("onSubscribe");
    }


    @Override
    public void onNext(T t) {

        LU.he("Observer_onNext"+t);
    }

    @Override
    public void onError(Throwable e) {
        LU.he("onError_" + e.toString());

        disPos();
    }

    @Override
    public void onComplete() {
        LU.he("onComplete");
        disPos();
    }

    /**
     * 取消网络请求
     */
    public void disPos() {
        if (mDis != null && !mDis.isDisposed()) {
            mDis.dispose();
        }
    }



    public Disposable getmDis() {
        return mDis;
    }

}
