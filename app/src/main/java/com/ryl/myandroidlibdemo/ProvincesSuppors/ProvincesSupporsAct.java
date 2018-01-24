package com.ryl.myandroidlibdemo.ProvincesSuppors;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ryl.myandroidlibdemo.R;
import com.ryl.myandroidlibdemo.base.BaseAct;
import com.ryl.myandroidlibdemo.base.InitActInterface;
import com.ryl.myandroidlibdemo.base.InitActivity;

/**
 * Created by rongyile on 2018/1/22.
 */

public class ProvincesSupporsAct extends InitActivity {


    private ProvincesFramgent mFragment;
    //    private MyProvinceDemoFragment mFragment;
    private ProvincesSupporsPre mPre;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected InitActInterface getInitInterface() {
        return this;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initShow() {
        mFragment = new ProvincesFramgent();
//        mFragment = new MyProvinceDemoFragment();
        mPre = new ProvincesSupporsPre(ProvincesSupporsAct.this, mFragment);
        mFragment.setPresenter(mPre);
        getFragmentManager().beginTransaction().replace(R.id.main_contain, mFragment, "detail").commit();

    }

    @Override
    public void prepareShow() {


    }
}
