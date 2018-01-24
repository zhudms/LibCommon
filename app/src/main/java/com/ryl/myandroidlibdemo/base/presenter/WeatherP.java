//package com.ryl.myandroidlibdemo.base.presenter;
//
//import android.content.Context;
//
//import com.ryl.commonlib.utils.LU;
//import com.ryl.commonlib.utils.ToastU;
//import com.ryl.myandroidlibdemo.bean.RetrofitResultParentB;
//import com.ryl.myandroidlibdemo.datahelper.ResponseLisener;
//import com.ryl.myandroidlibdemo.datahelper.WeatherDataHelper;
//import com.ryl.myandroidlibdemo.db.utils.DaoUtils;
//import com.ryl.myandroidlibdemo.testbean.Provinces;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import io.reactivex.ObservableOnSubscribe;
//
///**
// * Created by rongyile on 2017/12/22.
// */
//
//public class WeatherP {
//
//    private ArrayList<Provinces> mProvince;
//
//    private Context mContext;
//
//    private ResponseLisener<List<Provinces>> mResponseLIsener;
//
//    private ObservableOnSubscribe mm;
//
//    public WeatherP(Context mContext) {
//
//        this.mContext = mContext;
//
//        mResponseLIsener = new ResponseLisener<List<Provinces>>() {
//            @Override
//            public void onNetSuccess(List<Provinces> o) {
//
//                mProvince = ((ArrayList<Provinces>) o);
//                updataDB(mProvince);
//                updataShow();
//                LU.he(mProvince);
//            }
//
//            @Override
//            public void onFail(Object o) {
//                LU.hw("onWetherP_error=" + o);
//                LU.hw(o);
//            }
//
//
//            @Override
//            public void onDBSuccess(List<Provinces> provinces) {
//                LU.he("weatherP_onDBSuccess");
//                LU.he(provinces);
//            }
//        };
//
//
//    }
//
//    private void updataDB(List<Provinces> mWeatherSupportProvinces) {
//        boolean isSuccess = new DaoUtils<Provinces>(mContext).insertMulitEntity(mWeatherSupportProvinces);
//        LU.he("WeatherP_isDBSuccess=" +
//                "" + isSuccess);
//    }
//
//    public void showWeatherProvince() {//RxJava 应该写在 P 层?
//
//        getData(mResponseLIsener);
//
//    }
//
//    private boolean DealResultBean(RetrofitResultParentB weatherSupportProvince) {
//        return true;
//    }
//
//
//    private void getData(ResponseLisener lisener) {
//
////        WeatherDataHelper.getWeatherProvince(mContext, MyApplication.keys, lisener);
////        WeatherDataHelper.getProvinces(mContext);
//        new WeatherDataHelper().getProvinces(mContext, lisener);
//
//
//    }
//
////    private void  getData(){
////        WeatherDataHelper.getProvinces(mContext);
////    }
//
//    private void updataShow() {
//
//
////        ToastU.ht(mContext,"hahahhah");
//    }
//
//    private void updataShow(String errorMessage) {
//        ToastU.ht(mContext, "onerror");
//    }
//
//
//
//    //        Observable<List<Provinces>> observable;
////
////        if (NetUtil.isNetworkUseful(mContext)) {
////            Observable<WeatherSupportProvince> observableP;
////
////
////            observableP = ObserableHelper.getWeatherNetProvinceObserable(MyApplication.keys)
////                    .map(new Function<WeatherSupportProvince, WeatherSupportProvince>() {
////                        @Override
////                        public WeatherSupportProvince apply(WeatherSupportProvince weatherSupportProvince) throws Exception {
////                            boolean result = DealResultBean(weatherSupportProvince);
////
////                            return weatherSupportProvince;
////                        }
////                    });
////
////            observable = observableP
////
////                    .map(new Function<WeatherSupportProvince, List<Provinces>>() {
////
////                        @Override
////                        public List<Provinces> apply(WeatherSupportProvince weatherSupportProvince) throws Exception {
////                            updataDB(weatherSupportProvince.getResult());
////                            return weatherSupportProvince.getResult();
////                        }
////                    });
////
////            observable.subscribe(new Consumer<List<Provinces>>() {
////                @Override
////                public void accept(List<Provinces> provinces) throws Exception {
////                    LogUtils.e("provice=" + provinces);
////
////                }
////            });
////        } else {
//////             observable = ObserableHelper.getWeatherDBProvinceObserable(MyApplication.keys);
//////            Observable<List<Provinces>> observable2 = ObserableHelper.getWeatherDBProvinceObserable(MyApplication.keys);
////
////        }
//
//
////        Observable<WeatherSupportProvince> observableP;
////        Observable<List<Provinces>> observable;
////
////        if (NetUtil.isNetworkUseful(mContext)) {
////            observableP = ObserableHelper.getWeatherNetProvinceObserable(MyApplication.keys)
////                    .map(new Function<WeatherSupportProvince, WeatherSupportProvince>() {
////                        @Override
////                        public WeatherSupportProvince apply(WeatherSupportProvince weatherSupportProvince) throws Exception {
////                            boolean result = DealResultBean(weatherSupportProvince);
////
////                            return weatherSupportProvince;
////                        }
////                    });
////
////            observable = observableP
////
////                    .map(new Function<WeatherSupportProvince, List<Provinces>>() {
////
////                        @Override
////                        public List<Provinces> apply(WeatherSupportProvince weatherSupportProvince) throws Exception {
////                            updataDB(weatherSupportProvince.getResult());
////                            return weatherSupportProvince.getResult();
////                        }
////                    });
//////
////        } else {
////            observable = Observable.create(new ObservableOnSubscribe<List<Provinces>>() {
////                @Override
////                public void subscribe(ObservableEmitter<List<Provinces>> e) throws Exception {
////
////                }
////
////            });
////        }
////
////        Observable<List<Provinces>> observable2 = ObserableHelper.getWeatherDBProvinceObserable(MyApplication.keys);
////
////        Observable.concat(observable, observable2).firstOrError()
////                .subscribe(new Consumer<List<Provinces>>() {
////            @Override
////            public void accept(List<Provinces> provinces) throws Exception {
////                LogUtils.e("provice="+provinces);
////
////            }
////        });
//
//
////
////        Observable<WeatherSupportProvince> observable = Observable.create(new ObservableOnSubscribe<WeatherSupportProvince>() {
////            @Override
////            public void subscribe(ObservableEmitter<WeatherSupportProvince> e) throws Exception {
////                LogUtils.e(e);
//////                if (NetUtil.isNetworkUseful(MainActivity.this)) {
//////
//////                    Flowable<WeatherSupportProvince> call = MyApplication.mHttp.getSupportProvince(MyApplication.keys);
//////                    e.onNext();
//////                } else {
//////                    //get from DB
//////                }
////            }
////        });
//
//
//    //        Observable<Provinces> observable3 = Observable.create(new ObservableOnSubscribe<Provinces>() {
////            @Override
////            public void subscribe(ObservableEmitter<Provinces> e) throws Exception {
////                LogUtils.e(e);
////            }
////        });
//
////        Observable<Provinces> ob=Observable.concat(observable,observable3);
//
//
////        observable.flatMap(new Function<WeatherSupportProvince, ObservableSource<?>>() {
////            @Override
////            public ObservableSource<?> apply(final WeatherSupportProvince weatherSupportProvince) throws Exception {
////                return new ObservableSource<Provinces>() {
////                    @Override
////                    public void subscribe(Observer<? super Provinces> observer) {
////                        Observable.just(weatherSupportProvince.getResult());
////                    }
////                };
////            }
////        });
//
//
//}
