package com.sing.simple;

public class Conname {
    public static void main(String[] args) {
        //买了一辆五菱宏光
        Car wuling = new Wuling();
        //买了一辆特斯拉
        Car tesla = new Tesla();
        wuling.name();
        tesla.name();
    }
}
