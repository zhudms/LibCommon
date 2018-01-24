package com.ryl.myandroidlibdemo.ProvincesSuppors;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSONObject;
import com.ryl.myandroidlibdemo.R;
import com.ryl.myandroidlibdemo.testbean.Provinces;


import java.util.ArrayList;

/**
 * Created by rongyile on 2018/1/23.
 */

public class MyProvinceDemoFragment extends Fragment {
    public RecyclerView mProvinceView;
    public ArrayList<Provinces> lists;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.provincessuppor_layout, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProvinceView = ((RecyclerView) view.findViewById(R.id.provinces_list));
//        ButterKnife.bind(view);
        mProvinceView.setLayoutManager(new LinearLayoutManager(getActivity()));
        lists = new ArrayList<>(2);
        lists.add(new Provinces("1", "北京"));
        lists.add(new Provinces("2", "深圳"));
        ProvinceAdapter adapter=new ProvinceAdapter(lists, getActivity());
        mProvinceView.setAdapter(adapter);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


}
