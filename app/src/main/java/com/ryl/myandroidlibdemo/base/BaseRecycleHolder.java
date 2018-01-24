package com.ryl.myandroidlibdemo.base;


import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * ButterKnife 注册
 * Created by rongyile on 2018/1/24.
 */

public class BaseRecycleHolder extends RecyclerView.ViewHolder {
    public BaseRecycleHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
