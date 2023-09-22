package com.sing.CarFactory;

import com.sing.simple.Car;
import com.sing.simple.Wuling;

public class WulingFactory implements CarFactory{
    //生产五菱宏光汽车
    public Car getCar(){
        return new Wuling();
    }
}
