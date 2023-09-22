package com.sing.abstraction;

/**
 *华为工厂
 */
public class HuaweiFactory implements IProductFactory{
    public IPhoneProduct getPhone() {
        return new HuaweiPhone();
    }

    public IRouterProduct getRouter() {
        return new HuaweiRouter();
    }
}
