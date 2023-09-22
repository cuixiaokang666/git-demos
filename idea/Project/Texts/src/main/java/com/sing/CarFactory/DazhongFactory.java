package com.sing.CarFactory;

import com.sing.simple.Car;

public class DazhongFactory implements CarFactory {
    //生产大众汽车
    public Car getCar(){
        return new Dazhong();
    }
}
