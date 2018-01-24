package com.ryl.myandroidlibdemo.base;

/**
 * Created by rongyile on 2017/12/22.
 */

public interface InitActInterface {

    /**
     * 显示界面需要的数据准备
     */
    void initData();

    /**
     * 显示界面需要的界面准备
     */
    void initShow();

    /**
     * 数据和界面的关联
     */
    void prepareShow();
}
