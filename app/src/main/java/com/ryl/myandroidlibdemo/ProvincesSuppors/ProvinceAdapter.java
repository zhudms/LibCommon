package com.ryl.myandroidlibdemo.ProvincesSuppors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ryl.myandroidlibdemo.R;
import com.ryl.myandroidlibdemo.base.BaseRecycleAdapter;
import com.ryl.myandroidlibdemo.base.BaseRecycleHolder;
import com.ryl.myandroidlibdemo.testbean.Provinces;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by rongyile on 2018/1/22.
 */

public class ProvinceAdapter extends BaseRecycleAdapter<Provinces> {


    public ProvinceAdapter(List<Provinces> mLists, Context mContext) {
        super(mLists, mContext);
    }

    @Override
    public MHodle onCreateViewHolder(ViewGroup parent, int viewType) {

        View v=LayoutInflater.from(mContext).inflate(R.layout.provincesupport_item, parent, false);
        MHodle holder=new MHodle(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(BaseRecycleHolder holder, int position) {
        ((MHodle) holder).mIDTv.setText(mLists.get(position).getId());
        ((MHodle) holder).mNameTv.setText(mLists.get(position).getProvince());
    }


    @Override
    public int getItemCount() {
        return mLists.size();
    }


    static class MHodle extends BaseRecycleHolder {

        @BindView(R.id.provinces_id)
        TextView mIDTv;
        @BindView(R.id.provinces_name)
        TextView mNameTv;

        public MHodle(View itemView) {
            super(itemView);
        }


    }
}



