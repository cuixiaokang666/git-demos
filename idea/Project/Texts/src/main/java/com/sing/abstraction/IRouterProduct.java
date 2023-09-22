package com.sing.abstraction;

/**
 * 路由器产品接口
 */
public interface IRouterProduct {
    //开机
    void open();
    //关机
    void close();
    //设置参数
    void setting();
    //打开wifi
    void wifi();
}
