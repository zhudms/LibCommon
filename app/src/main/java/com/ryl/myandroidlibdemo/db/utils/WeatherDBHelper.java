package com.ryl.myandroidlibdemo.db.utils;

import android.content.Context;

import com.ryl.myandroidlibdemo.datahelper.ResponseLisener;
import com.ryl.myandroidlibdemo.testbean.Provinces;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * Created by rongyile on 2018/1/4.
 */

public class WeatherDBHelper extends BaseDBHelper<List<Provinces>,Provinces> {


    @Override
    public boolean updataDB(Context mContext, List<Provinces> mWeatherSupportProvinces) {
        boolean isSuccess = new DaoUtils<Provinces>(mContext).insertMulitEntity(mWeatherSupportProvinces);
//        LogUtils.e("isDBSuccess=" +
//                "" + isSuccess);

        return isSuccess;
    }



    /**
     * @param context
     */
    @Override
    public List<Provinces> getLocalData(Context context) {

//        return new DaoUtils(context).listAll(new Provinces());
        return new DaoUtils(context).quertyByWhereOr("fdsf");
    }


    /**
     * @param context
     */
    public List<Provinces> getLocalData(Context context,String s) {



//        Query query = userDao.queryRawCreate(
//                ", GROUP G WHERE G.NAME=? AND T.GROUP_ID=G._ID", "admin");
        return new DaoUtils(context).quertyByWhereOr("fdsf");

    }



}
