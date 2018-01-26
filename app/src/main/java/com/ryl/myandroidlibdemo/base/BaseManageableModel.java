package com.ryl.myandroidlibdemo.base;

import android.text.TextUtils;

import com.ryl.myandroidlibdemo.base.presenter.ManageableHttpRequest;
import com.ryl.myandroidlibdemo.bean.HttpCancelBean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import io.reactivex.disposables.Disposable;

/**
 * Created by rongyile on 2018/1/26.
 */

public class BaseManageableModel implements ManageableHttpRequest {

    protected HashMap<String, Disposable> disList;

    public BaseManageableModel() {
        disList = new HashMap<>();
    }


    @Override
    public void addDisposable(HttpCancelBean bean) {
        if (bean == null) {
            return;
        }

        disList.put(bean.getTag(), bean.getDisposable());
    }

    @Override
    public void removeDisposable(String tag) {

        if (TextUtils.isEmpty(tag) || disList.isEmpty()) {
            return;
        }

        Disposable disposable = disList.get(tag);

        if (disposable != null) {
            disList.remove(disList.get(tag));
        }

    }


    @Override
    public void clearHttpRequest() {

        if (disList == null || disList.size() == 0) {
            return;
        }

        Set<String> keySet = disList.keySet();

//        if (keySet != null && keySet.size() != 0) {
        Iterator<String> key = keySet.iterator();
        Disposable disposable = null;
        while (key.hasNext()) {
            disposable = disList.get(key.next());
            disposable.dispose();
        }
//        }

        disList.clear();
    }
}
