package com.sing.abstraction;

public class XiaomiPhone implements IPhoneProduct{
    public void open() {
        System.out.println("小米手机开机");
    }

    public void close() {
        System.out.println("小米手机关机");
    }

    public void send() {
        System.out.println("小米手机发短信");
    }

    public void call() {
        System.out.println("小米手机打电话");
    }
}
