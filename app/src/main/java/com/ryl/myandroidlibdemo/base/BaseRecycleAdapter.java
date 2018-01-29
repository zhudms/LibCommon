package com.ryl.myandroidlibdemo.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rongyile on 2018/1/29.
 */

public abstract  class BaseRecycleAdapter<T> extends RecyclerView.Adapter<BaseRecycleHolder> {

    protected List<T> mLists;
    protected Context mContext;

    public BaseRecycleAdapter(List<T> mLists, Context mContext) {
        this.mLists = mLists;
        this.mContext = mContext;
    }


}
