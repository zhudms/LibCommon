package com.ryl.myandroidlibdemo.testbean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by rongyile on 2017/12/21.
 */
@Entity
public class Provinces {

    @Id
    private String id;
    private String province;


    @Generated(hash = 804837564)
    public Provinces(String id, String province) {
        this.id = id;
        this.province = province;
    }

    @Generated(hash = 76428125)
    public Provinces() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

}
