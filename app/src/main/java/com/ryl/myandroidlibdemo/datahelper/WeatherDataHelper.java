package com.ryl.myandroidlibdemo.datahelper;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.ryl.commonlib.tools.StringUtils;
import com.ryl.commonlib.utils.LU;
import com.ryl.myandroidlibdemo.MyApplication;
import com.ryl.myandroidlibdemo.R;
import com.ryl.myandroidlibdemo.base.ManageableResponseLisner;
import com.ryl.myandroidlibdemo.bean.HttpCancelBean;
import com.ryl.myandroidlibdemo.bean.WeatherSupportProvince;
import com.ryl.myandroidlibdemo.db.utils.DBManageable;
import com.ryl.myandroidlibdemo.db.utils.WeatherDBHelper;
import com.ryl.myandroidlibdemo.rx.BaseObserver;
import com.ryl.myandroidlibdemo.rx.JHFunction;
import com.ryl.myandroidlibdemo.rx.ObserableHelper;
import com.ryl.myandroidlibdemo.testbean.Provinces;
import com.ryl.myandroidlibdemo.util.NetUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * 针对具体类,数据的处理(后台数据的脱壳(包括各种网络情况的处理)),与业务逻辑无关
 */

public class WeatherDataHelper /*extends BaseDataHelper<List<Provinces>>*/ implements DBManageable<List<Provinces>> {

    private WeatherDBHelper mDBHelper;
    private String errMsg;

    public WeatherDataHelper() {
        initDBHelper();
    }


    @Override
    public void initDBHelper() {
        mDBHelper = new WeatherDBHelper();
    }


    public HttpCancelBean getProvinces(final Context mContext, final ManageableResponseLisner responseLisener) {

        //网络请求取消句柄及 tag
        HttpCancelBean bean = null;

        if (NetUtil.isNetworkUseful(mContext)) {

            //同步

//            HttpSynService.getSupportProvince(MyApplication.keys, responseLisener);


            //异步


            final BaseObserver<List<Provinces>> baseObserver = new BaseObserver<List<Provinces>>();

            final JHFunction<WeatherSupportProvince, List<Provinces>> funct =
                    new JHFunction<>(responseLisener);

            Observable<List<Provinces>> observableP = ObserableHelper.getWeatherNetProvinceObserable(MyApplication.keys)
                    .map(funct)
                    .doOnNext(new Consumer<List<Provinces>>() {
                        @Override
                        public void accept(List<Provinces> provinces) throws Exception {
//                            LU.hw("WeatherDataHelper_doOnNext");
                            LU.hw(provinces);
                            responseLisener.onNetSuccess(provinces);
                        }
                    }).doOnError(new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            responseLisener.onFail(getErrorMessage(mContext, throwable));
                        }
                    });
            observableP.subscribe(baseObserver);

            Disposable dis = baseObserver.getmDis();
            bean = new HttpCancelBean(responseLisener.getTag(), dis);
        } else {

            try {
                List<Provinces> provinces = getLocalData(mContext);
                responseLisener.onDBSuccess(provinces);
            } catch (Exception e) {
                responseLisener.onFail(e.toString());
            }
        }

        return bean;

    }


    @Override
    public List<Provinces> getLocalData(Context context) {

        List<Provinces> list = mDBHelper.getLocalData(context);
        mDBHelper.closeDB(new Provinces());
        return list;

    }

    public String getErrorMessage(Context mContext, Throwable e) {

        if (!NetUtil.isNetworkUseful(mContext)) {
            errMsg = StringUtils.getString(mContext, R.string.net_error);
        } else if (e instanceof HttpException) {
            errMsg = StringUtils.getString(mContext, R.string.connection_error);
        } else if (e instanceof IOException) {
            errMsg = "IOException";
        } else {
            errMsg = StringUtils.getString(mContext, R.string.no_more);
        }

        return errMsg;
    }


}
