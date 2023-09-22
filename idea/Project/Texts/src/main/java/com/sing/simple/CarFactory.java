package com.sing.simple;

public class CarFactory {
    //封装生产车的细节

    public static Car getCar(String name){
        if("五菱宏光".equals(name)){
            return new Wuling();
        }else if("特斯拉".equals(name)){
            return new Tesla();
        }else if("奔驰迈巴赫".equals(name)){
            return new Benchi();
        }
        return null;
    }

    public static void main(String[] args) {
        //简单工程模式(静态工厂模式)
        Car wu = CarFactory.getCar("五菱宏光");
        Car ts = CarFactory.getCar("特斯拉");
        Car bc = CarFactory.getCar("奔驰迈巴赫");
        wu.name();
        ts.name();
        bc.name();
    }
}
