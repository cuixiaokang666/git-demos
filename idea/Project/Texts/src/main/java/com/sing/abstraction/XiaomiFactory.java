package com.sing.abstraction;

/**
 * 小米工厂
 */
public class XiaomiFactory implements IProductFactory{
    public IPhoneProduct getPhone() {
        return new XiaomiPhone();
    }

    public IRouterProduct getRouter() {
        return new XiaomiRouter();
    }
}
