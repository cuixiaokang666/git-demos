package com.sing.abstraction;

public class XiaomiRouter implements IRouterProduct{
    public void open() {
        System.out.println("小米路由器开机");
    }

    public void close() {
        System.out.println("小米路由器关机");
    }

    public void setting() {
        System.out.println("小米路由器设置参数");
    }

    public void wifi() {
        System.out.println("小米路由器打开wifi");
    }
}
