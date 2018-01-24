package com.ryl.myandroidlibdemo.ProvincesSuppors;

import com.ryl.myandroidlibdemo.base.presenter.BaseModel;
import com.ryl.myandroidlibdemo.base.presenter.BasePresenter;
import com.ryl.myandroidlibdemo.base.presenter.BaseView;
import com.ryl.myandroidlibdemo.testbean.Provinces;

import java.util.List;

/**
 * Created by rongyile on 2018/1/22.
 */

//定义需要实现的方法
public interface ProvinceSupportsContract {

    interface View extends BaseView<Presenter> {
//        void showProvinceSupports();

        void setProvincesAdapter(ProvinceAdapter adapter);
    }


    interface Presenter extends BasePresenter {
        void showLists(List<Provinces> lists);


        ProvinceAdapter getProvinceAdapter();

        void getProvinces();

        void showEmptyView();
    }


    interface Model extends BaseModel<List<Provinces>>{
        boolean updataDB(List<Provinces> provinces);
        void showLists(List<Provinces> provinces);
    }
}
