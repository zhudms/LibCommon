package com.ryl.myandroidlibdemo.ProvincesSuppors;

import android.content.Context;

import com.ryl.commonlib.utils.LU;
import com.ryl.myandroidlibdemo.base.BaseManageableModel;
import com.ryl.myandroidlibdemo.base.ManageableResponseLisner;
import com.ryl.myandroidlibdemo.base.presenter.ManageableHttpRequest;
import com.ryl.myandroidlibdemo.bean.HttpCancelBean;
import com.ryl.myandroidlibdemo.datahelper.ResponseLisener;
import com.ryl.myandroidlibdemo.datahelper.WeatherDataHelper;
import com.ryl.myandroidlibdemo.db.utils.WeatherDBHelper;
import com.ryl.myandroidlibdemo.testbean.Provinces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import io.reactivex.disposables.Disposable;

/**
 * //context 满天飞,必须整理处理
 * 具体业务逻辑,M 层
 * <p>
 * Created by rongyile on 2018/1/23.
 */

public class ProvinceSupporsModel extends BaseManageableModel implements ProvinceSupportsContract.Model {

    private Context mContext;

    private WeatherDataHelper mWeatherDataHelper;
    private ProvincesSupporsPre mProvincesSupporsPre;
    private WeatherDBHelper mDBHelper;


    public ProvinceSupporsModel(Context context, ProvincesSupporsPre mProvincesSupporsPre) {
        super();
        mContext = context;
        this.mProvincesSupporsPre = mProvincesSupporsPre;
        mWeatherDataHelper = new WeatherDataHelper();
        mDBHelper = new WeatherDBHelper();
    }


    @Override
    public void getData() {

        final MManageableResponseLisener  lisner =new MManageableResponseLisener(String.valueOf(System.currentTimeMillis()));

        HttpCancelBean bean = mWeatherDataHelper.getProvinces(mContext, lisner);

        addDisposable(bean);
    }


    @Override
    public boolean updataDB(List<Provinces> o) {
        return mDBHelper.updataDB(mContext, o);
    }

    @Override
    public void showLists(List<Provinces> o) {
        mProvincesSupporsPre.showLists(o);
    }


    @Override
    public void clearHttpRequest() {
        super.clearHttpRequest();
        mWeatherDataHelper=null;
    }

    class MManageableResponseLisener extends ManageableResponseLisner<List<Provinces>> {

        public MManageableResponseLisener(String tag) {
            super(tag);
        }

        @Override
        public void onNetSuccess(List<Provinces> o) {
            updataDB(((List<Provinces>) o));
            showLists(o);
            removeDisposable(getTag());
        }

        @Override
        public void onDBSuccess(List<Provinces> o) {
            showLists(o);
        }

        @Override
        public void onFail(Object o) {
            mProvincesSupporsPre.showEmptyView();
            LU.hd("asd", "onFail");
            if (this.getTag() != null) {
                removeDisposable(getTag());
            }

        }
    }

}
