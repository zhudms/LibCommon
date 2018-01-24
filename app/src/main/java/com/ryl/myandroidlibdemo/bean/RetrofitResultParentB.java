package com.ryl.myandroidlibdemo.bean;

import java.io.Serializable;

/**
 * Created by TANG on 2016/4/7.
 */
public abstract class RetrofitResultParentB implements Serializable {

    private static final long serialVersionUID = -6289966025216473737L;
    public static final int REQUEST_SUCCESS_DEFAULT = 0;
//    public static final String REQUEST_SUCCESS="1";
//    public static final String REQUEST_FAIL="0";

    private String MESSAGE;
    private int FLAG;
    private int error_code;
    private String TYPE;


    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public int getFLAG() {
        return FLAG;
    }

    public void setFLAG(int FLAG) {
        this.FLAG = FLAG;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }


    abstract  public Object getRealData();
}
