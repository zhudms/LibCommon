package com.ryl.myandroidlibdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by rongyile on 2017/12/21.
 */

public abstract class BaseAct extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutID());


    }

    protected abstract int getLayoutID();


}
