package com.ryl.myandroidlibdemo.testbean;

/**
 * Created by rongyile on 2018/1/3.
 */

public class FailMessageObj {

    public static final int FAILCODE_DEFAULT=-1;

    private int errorCode=FAILCODE_DEFAULT;
    private String errorMessage="";


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public FailMessageObj(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public FailMessageObj(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public FailMessageObj(int errorCode) {

        this.errorCode = errorCode;
    }
}
