package com.ryl.myandroidlibdemo.bean;

/**
 * Created by TANG on 2016/4/25.
 */
public class ResultB<T> extends RetrofitResultParentB {

   private static final long serialVersionUID = -5989776503129673079L;
   public T INFO;

   public T getINFO() {
      return INFO;
   }

   public void setINFO(T INFO) {
      this.INFO = INFO;
   }


   @Override
   public Object getRealData() {
      return getINFO();
   }
}
