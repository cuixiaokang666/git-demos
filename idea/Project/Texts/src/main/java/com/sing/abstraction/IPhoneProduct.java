package com.sing.abstraction;

/**
 * 手机产品接口
 */
public interface IPhoneProduct {
    //开机
    void open();
    //关机
    void close();
    //发短信
    void send();
    //打电话
    void call();
}
