package com.ryl.myandroidlibdemo.ProvincesSuppors;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ryl.myandroidlibdemo.R;
import com.ryl.myandroidlibdemo.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by rongyile on 2018/1/22.
 */

public class ProvincesFramgent extends BaseFragment implements ProvinceSupportsContract.View {


    public ProvinceSupportsContract.Presenter mPresenter;

    @BindView(R.id.provinces_list)
    public RecyclerView mProvinceView;


    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.provincessuppor_layout, container, false);
//        mProvinceView = ((RecyclerView) view.findViewById(R.id.provinces_list));

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProvinceView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mProvinceView.setAdapter(mPresenter.getProvinceAdapter());
    }

    @Override
    public void onResume() {
        super.onResume();

        mPresenter.subscribe();
    }

    @Override
    public void onStop() {
        super.onStop();

        mPresenter.unsubscribe();
    }

    @Override
    public void setPresenter(ProvinceSupportsContract.Presenter presenter) {
        this.mPresenter = presenter;
    }


    @Override
    public void setProvincesAdapter(ProvinceAdapter adapter) {
        mProvinceView.setAdapter(adapter);
    }
}
