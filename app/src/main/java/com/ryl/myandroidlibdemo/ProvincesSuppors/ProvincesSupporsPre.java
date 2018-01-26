package com.ryl.myandroidlibdemo.ProvincesSuppors;

import android.content.Context;

import com.ryl.commonlib.utils.ToastU;
import com.ryl.myandroidlibdemo.testbean.Provinces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by rongyile on 2018/1/22.
 */

public class ProvincesSupporsPre implements ProvinceSupportsContract.Presenter, Serializable {

    private static final long serialVersionUID = 3311411082810131263L;

    private Context mContext;

    private ProvinceSupporsModel mModel;

    private ProvincesFramgent mView;
    private List<Provinces> mProvincesSupports;
    private ProvinceAdapter mAdapter;

    private CompositeDisposable compositeDisposable;

    public ProvincesSupporsPre(Context context, ProvincesFramgent view) {

        this.mView = view;
        this.mContext = context;

        mModel = new ProvinceSupporsModel(mContext, this);
        mProvincesSupports = new ArrayList<Provinces>();
        mAdapter = new ProvinceAdapter(mProvincesSupports, mContext);

    }


    @Override
    public ProvinceAdapter getProvinceAdapter() {
        return mAdapter;
    }

    @Override
    public void getProvinces() {
        mModel.getData();

    }

    @Override
    public void showEmptyView() {
        ToastU.ht(mContext, "暂无数据");
    }


    @Override
    public void showLists(List<Provinces> lists) {
        if (lists == null || lists.size() == 0) {

            showEmptyView();
            return;
        }

        mProvincesSupports.clear();
        mProvincesSupports.addAll(lists);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void subscribe() {
        this.mView.setPresenter(this);
        getProvinces();
    }

    @Override
    public void unsubscribe() {
        mModel.clearHttpRequest();
        mModel = null;
    }


}
