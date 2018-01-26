package com.ryl.myandroidlibdemo.base.presenter;

import com.ryl.myandroidlibdemo.bean.HttpCancelBean;

/**
 * Created by rongyile on 2018/1/26.
 */

public interface ManageableHttpRequest {
    void clearHttpRequest();

    void addDisposable(HttpCancelBean bean);

    void removeDisposable(String tag);
}
