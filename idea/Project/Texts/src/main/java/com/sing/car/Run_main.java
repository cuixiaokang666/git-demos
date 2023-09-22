package com.sing.car;

public class Run_main {
    public static void main(String[] args) {
        People people = new People();
        people.setCash(60000);
        people.setUsername("小明");

        People people1 = new People();
        people1.setCash(40000);
        people1.setUsername("小赵");

        People people2 = new People();
        people2.setCash(0);
        people2.setUsername("tom");
        people2.setVip("vip");

        Proxy proxy = new Proxy();
        proxy.setPeople(people);
        proxy.buy_mycar();

        proxy.setPeople(people1);
        proxy.buy_mycar();

        proxy.setPeople(people2);
        proxy.buy_mycar();
    }
}
