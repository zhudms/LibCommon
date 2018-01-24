package com.ryl.myandroidlibdemo.datahelper;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.ryl.commonlib.tools.StringUtils;
import com.ryl.commonlib.utils.LU;
import com.ryl.myandroidlibdemo.MyApplication;
import com.ryl.myandroidlibdemo.R;
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

import io.reactivex.Observable;
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


    //    /**
//     * 1
//     * @param context
//     * @param key
//     * @param lisener
//     */
//    public static void getWeatherProvince(Context context, String key, final ResponseLisener lisener) {
//
//        //判断数据源
//        if (NetUtil.isNetworkUseful(context)) {
//
//            //数据处理完成(脱壳),回调给 P 层
//            final NetResultLisener<WeatherSupportProvince> pr = new NetResultLisener<WeatherSupportProvince>() {
//                @Override
//                public void onSuccess(WeatherSupportProvince message) {
//                    lisener.onNetSuccess(message.getResult());
//                    LU.he(message);
//                }
//
//                @Override
//                public void onFail(Object errorMessage) {
//                    lisener.onFail(errorMessage.toString());
//                }
//            };
//
//            HttpService.getSupportProvince(key, new RetrofitCallBackCoreImplent(pr));
//
//
//            HttpSynService.getSupportProvince(MyApplication.keys, new RetrofitCallBackCoreImplent(pr));
//
//        } else {
//            getLocalData(context, lisener, Provinces.class);
//        }
//
//    }


//    TextView tv;


//    Function<? extends RetrofitResultParentB, ? extends Object> function
//            = new Function<RetrofitResultParentB, Object>() {
//
//        @Override
//        public Object apply(RetrofitResultParentB retrofitResultParentB) throws Exception {
//            if (retrofitResultParentB.getFLAG() == RetrofitResultParentB.REQUEST_SUCCESS_DEFAULT) {
//                return retrofitResultParentB;
//            } else {
//
//            }
//        }
//    };

    public void getProvinces(final Context mContext, final ResponseLisener responseLisener) {


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

        } else {

            try {
                List<Provinces> provinces = getLocalData(mContext);
                responseLisener.onDBSuccess(provinces);
            } catch (Exception e) {
                responseLisener.onFail(e.toString());
            }
        }
//        final BaseObserver<List<Provinces>> baseObserver = new BaseObserver<List<Provinces>>(responseLisener, mContext);
//        final RYLFunction<WeatherSupportProvinceRx, List<Provinces>> funct =
//                new RYLFunction<>(responseLisener);
//        Observable<List<Provinces>> observableP = ObserableHelper.getWeatherNetProvinceObserableRx(MyApplication.keys)
//                .map(funct);
//
//        //                        new Function<WeatherSupportProvinceRx, List<Provinces>>() {
////                    @Override
////                    public List<Provinces> apply(WeatherSupportProvinceRx weatherSupportProvince) throws Exception {
////                        if (weatherSupportProvince.getFLAG() == RetrofitResultParentB.REQUEST_SUCCESS_DEFAULT) {
////                            return weatherSupportProvince.getResult();
////                        } else {
////
////                            responseLisener.onFail(weatherSupportProvince.getError_code());
////                            return null;
////                        }
////
////
////                    }
////                }
//
//
//        observableP.subscribe(baseObserver);
////                .map(new Function<WeatherSupportProvince, WeatherSupportProvince>() {
////                    @Override
////                    public WeatherSupportProvince apply(WeatherSupportProvince weatherSupportProvince) throws Exception {
////                        LU.he("first map");
////
//////                        boolean result = DealResultBean(weatherSupportProvince);
//////                                if (result) {
//////                                    return weatherSupportProvince;
//////                                } else {
////                        baseObserver.disPos();
////                        return null;
//////                                }
////                    }
////                })
////                .map(new Function<WeatherSupportProvince, List<Provinces>>() {
////
////                    @Override
////                    public List<Provinces> apply(WeatherSupportProvince weatherSupportProvince) throws Exception {
////                        LU.he("second map");
////
////                        return weatherSupportProvince.getResult();
////                    }
////                })
////                .subscribe(baseObserver);

    }


    /*
    context 滿天飛 怎麼辦
     */
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

    @Override
    public void initDBHelper() {
        mDBHelper = new WeatherDBHelper();
    }

    @Override
    public void updataDB(Context context, List<Provinces> provinces) {
        mDBHelper.updataDB(context, provinces);
    }

    @Override
    public List<Provinces> getLocalData(Context context) {


        List<Provinces> list = mDBHelper.getLocalData(context);
        mDBHelper.closeDB(new Provinces());
        return list;

    }


//    /**
//     * 2
//      * @param mContext
//     * @param lisener
//     */
//    public static void getProvinces(final Context mContext, final ResponseLisener lisener) {
//        Observable<List<Provinces>> observable;
//
//        if (NetUtil.isNetworkUseful(mContext)) {
//            try {
//                Observable<WeatherSupportProvince> observableP;
//
//
//                observableP = ObserableHelper.getWeatherNetProvinceObserable(MyApplication.keys)
//                        .map(new Function<WeatherSupportProvince, WeatherSupportProvince>() {
//                            @Override
//                            public WeatherSupportProvince apply(WeatherSupportProvince weatherSupportProvince) throws Exception {
//                                boolean result = DealResultBean(weatherSupportProvince);
//                                if (result) {
//                                    return weatherSupportProvince;
//                                } else {
//                                    return null;
//                                }
//                            }
//                        });
//
//                observable = observableP
//
//                        .map(new Function<WeatherSupportProvince, List<Provinces>>() {
//
//                            @Override
//                            public List<Provinces> apply(WeatherSupportProvince weatherSupportProvince) throws Exception {
//                                if (weatherSupportProvince == null
//                                        || weatherSupportProvince.getError_code()
//                                        != WeatherSupportProvince.REQUEST_SUCCESS_DEFAULT) {
//                                    updataDB(mContext, weatherSupportProvince.getResult());
//                                    return weatherSupportProvince.getResult();
//                                } else {
//                                    lisener.onFail(new FailMessageObj(weatherSupportProvince.getError_code(),
//                                            weatherSupportProvince.getMESSAGE()));
//
//                                    return null;
//                                }
//                            }
//                        });
//
//
//                observable.subscribe(new Consumer<List<Provinces>>() {
//                    @Override
//                    public void accept(List<Provinces> provinces) throws Exception {
//
//                        lisener.onNetSuccess(provinces);
//                    }
//
//
//                });
//
//
////                observable.subscribe(new Observer<List<Provinces>>() {
////                    @Override
////                    public void onSubscribe(Disposable d) {
////                        LogUtils.e("request subscribe" + d);
////                    }
////
////                    @Override
////                    public void onNext(List<Provinces> provinces) {
////                        LogUtils.e("request onNext" + provinces);
////                    }
////
////                    @Override
////                    public void onError(Throwable e) {
////                        LogUtils.e("request onError " + e);
////                    }
////
////                    @Override
////                    public void onComplete() {
////                        LogUtils.e("request onComplete ");
////                    }
////                });
//
//
//            } catch (Exception e) {
//                lisener.onFail(new FailMessageObj(e.toString()));
//            }
//        } else {
////             observable = ObserableHelper.getWeatherDBProvinceObserable(MyApplication.keys);
////            Observable<List<Provinces>> observable2 = ObserableHelper.getWeatherDBProvinceObserable(MyApplication.keys);
//            List<Provinces> list = new DaoUtils<Provinces>(mContext).listAll(new Provinces());
//            if (list == null || list.isEmpty()) {
//
//                lisener.onFail(new FailMessageObj(
//                        StringUtils.getString(mContext, com.ryl.commonlibrary.R.string.db_null)));
//            } else {
//                lisener.onDBSuccess(list);
//            }
//
//
//        }
//
//
//    }

//
//    public static boolean DealResultBean(RetrofitResultParentB weatherSupportProvince) {
//
//        if (weatherSupportProvince.getFLAG() == RetrofitResultParentB.REQUEST_SUCCESS_DEFAULT) {
//            return true;
//        } else {
//            return false;
//        }
//
//    }


}
