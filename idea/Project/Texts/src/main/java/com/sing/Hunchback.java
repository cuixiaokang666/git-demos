package com.sing;

public class Hunchback {
    //创建唯一一个饿汉式单例对象
    private static Hunchback sing = new Hunchback();
    //不能让外界直接创建对象,所以设置私有构造器
    private Hunchback(){

    }
    //单例对象的全局访问点 return
    public static Hunchback getInstance(){
        return sing;
    }
}
