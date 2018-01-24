package com.ryl.myandroidlibdemo.ProvincesSuppors;

import android.content.Context;

import com.ryl.commonlib.utils.LU;
import com.ryl.myandroidlibdemo.datahelper.ResponseLisener;
import com.ryl.myandroidlibdemo.datahelper.WeatherDataHelper;
import com.ryl.myandroidlibdemo.db.utils.WeatherDBHelper;
import com.ryl.myandroidlibdemo.testbean.Provinces;

import java.util.List;

/**
 * //context 满天飞,必须整理处理
 * 具体业务逻辑,M 层
 * <p>
 * Created by rongyile on 2018/1/23.
 */

public class ProvinceSupporsModel implements ProvinceSupportsContract.Model {

    private Context mContext;

    private WeatherDataHelper mWeatherDataHelper;
    private ProvincesSupporsPre mProvincesSupporsPre;
    private WeatherDBHelper mDBHelper;


    public ProvinceSupporsModel(Context context, ProvincesSupporsPre mProvincesSupporsPre) {

        mContext=context;
        this.mProvincesSupporsPre = mProvincesSupporsPre;
        mWeatherDataHelper = new WeatherDataHelper();
        mDBHelper = new WeatherDBHelper();



    }


    @Override
    public void getData() {
        mWeatherDataHelper.getProvinces(mContext, new ResponseLisener<List<Provinces>>() {
            @Override
            public void onNetSuccess(List<Provinces> o) {
                updataDB(((List<Provinces>) o));
                showLists(o);
            }

            @Override
            public void onDBSuccess(List<Provinces> o) {
                showLists(o);
            }

            @Override
            public void onFail(Object o) {
                mProvincesSupporsPre.showEmptyView();
                LU.hd("asd", "onFail");
            }
        });
    }

    @Override
    public boolean updataDB(List<Provinces> o) {
        return mDBHelper.updataDB(mContext, o);
    }

    @Override
    public void showLists(List<Provinces> o) {
        mProvincesSupporsPre.showLists(o);
    }
}
