package com.ryl.myandroidlibdemo.net;


/**
 * Created by TANG on 2016/3/4.
 */
public class ClientAPI {

    public static final String LOGIN = "LOGIN";

    public static  String BASE_URL="192.168.1.53:8080";
//    public static String BASE_HTTP ="http://" + BASE_URL + "/";
    public static String BASE_HTTP ="http://v.juhe.cn/";
//    public static String BASE_URL = null;
//    public static String BASE_HTTP = null/*"http://" + BASE_URL + "/"*/;

    public static String BASE_WS = null;

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
        BASE_HTTP = "http://" + BASE_URL + "/";
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

}
