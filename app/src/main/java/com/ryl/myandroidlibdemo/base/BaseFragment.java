package com.ryl.myandroidlibdemo.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by rongyile on 2018/1/24.
 */

public class BaseFragment extends Fragment {

    protected Unbinder mUnbinder;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();

    }
}
