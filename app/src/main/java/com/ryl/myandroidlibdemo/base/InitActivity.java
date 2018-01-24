package com.ryl.myandroidlibdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by rongyile on 2017/12/25.
 */

public abstract  class InitActivity extends BaseAct implements InitActInterface {

    protected InitActInterface mInitInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInitInterface = getInitInterface();
        if (mInitInterface != null) {
            mInitInterface.initData();
            mInitInterface.initShow();
            mInitInterface.prepareShow();
        }

    }


    protected abstract InitActInterface getInitInterface();

    protected void setInitInterface(InitActInterface initInterface) {
        this.mInitInterface = initInterface;
    }


}
