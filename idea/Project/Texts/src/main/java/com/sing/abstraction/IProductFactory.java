package com.sing.abstraction;

/**
 *抽象工厂
 */
public interface IProductFactory {
    //生产手机
    IPhoneProduct getPhone();
    //生产路由器
    IRouterProduct getRouter();
}
