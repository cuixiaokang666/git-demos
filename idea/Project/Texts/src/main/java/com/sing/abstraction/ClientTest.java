package com.sing.abstraction;

public class ClientTest {
    public static void main(String[] args) {
        System.out.println("========小米系列产品========");
        //创建小米工厂
        IProductFactory factory = new XiaomiFactory();
        IPhoneProduct phoneProduct = factory.getPhone();
        phoneProduct.send();
        phoneProduct.call();
        IRouterProduct router = factory.getRouter();
        router.setting();
        router.wifi();
        System.out.println("========华为系列产品========");
        IProductFactory factory1 = new HuaweiFactory();
        IPhoneProduct phoneProduct1 = factory1.getPhone();
        phoneProduct1.send();
        phoneProduct1.call();
        IRouterProduct router1 = factory1.getRouter();
        router1.setting();
        router1.wifi();
    }
}
