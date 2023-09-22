package com.sing.CarFactory;

import com.sing.simple.Car;
import com.sing.simple.Tesla;

public class TeslaFactory implements CarFactory{
    //生产特斯拉汽车

    public Car getCar() {
        return new Tesla();
    }
}
