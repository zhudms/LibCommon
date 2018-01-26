package com.ryl.myandroidlibdemo.base.presenter;

import com.ryl.myandroidlibdemo.bean.HttpCancelBean;

/**
 * Created by rongyile on 2018/1/26.
 */

public interface ManageableHttpRequest {
    /**
     * 解决在网络请求时界面关闭导致的内存泄露
     */
    void clearHttpRequest();

    void addDisposable(HttpCancelBean bean);

    void removeDisposable(String tag);
}
