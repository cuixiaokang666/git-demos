package com.sing.abstraction;

public class HuaweiPhone implements IPhoneProduct{
    public void open() {
        System.out.println("华为手机开机");
    }

    public void close() {
        System.out.println("华为手机关机");
    }

    public void send() {
        System.out.println("华为手机发短信");
    }

    public void call() {
        System.out.println("华为手机打电话");
    }
}
