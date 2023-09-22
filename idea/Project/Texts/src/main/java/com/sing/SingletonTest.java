package com.sing;

public class SingletonTest extends Thread{

    //饿汉式
//    public void run(){
//        Hunchback instance = Hunchback.getInstance();
//        System.out.println(instance);
//    }
    //懒汉式
    public void run(){
        Lazybones instance = Lazybones.getInstance();
        System.out.println(instance);
    }
    //测试方法
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            SingletonTest singletonTest = new SingletonTest();
            singletonTest.start();
        }
    }
}
