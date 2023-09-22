package com.sing.CarFactory;

import com.sing.simple.Car;

public class Test {
    public static void main(String[] args) {
        Car wl = new WulingFactory().getCar();
        Car ts = new TeslaFactory().getCar();
        Car dz = new DazhongFactory().getCar();

        wl.name();
        ts.name();
        dz.name();
    }
}
