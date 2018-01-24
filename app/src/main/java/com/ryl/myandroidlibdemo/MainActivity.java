//package com.ryl.myandroidlibdemo;
//
//import com.ryl.myandroidlibdemo.base.InitActInterface;
//import com.ryl.myandroidlibdemo.base.InitActivity;
//import com.ryl.myandroidlibdemo.base.presenter.WeatherP;
//
//public class MainActivity extends InitActivity{
//
//    private static final String TAG = "MainActivity:";
//
//
//    private WeatherP weatherP;
//
//    @Override
//    protected int getLayoutID() {
//        return R.layout.activity_main;
//    }
//
//    @Override
//    protected InitActInterface getInitInterface() {
//        return this;
//    }
//
//    @Override
//    public void initData() {
//        weatherP=new WeatherP(MainActivity.this);
//
//    }
//
//    @Override
//    public void initShow() {
//
//    }
//
//    @Override
//    public void prepareShow() {
//        weatherP.showWeatherProvince();
//    }
//
//}
