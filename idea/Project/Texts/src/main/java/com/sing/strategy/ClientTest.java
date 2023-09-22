package com.sing.strategy;

public class ClientTest  {
    public static void main(String[] args) {
        System.out.println("========野鸭子========");
        WildDuck wildDuck = new WildDuck();
        wildDuck.swimming();

        System.out.println("========北京鸭========");
        PekingDuck pekingDuck = new PekingDuck();
        pekingDuck.swimming();
        System.out.println("========玩具鸭========");
        ToyDuck toyDuck = new ToyDuck();
        toyDuck.swimming();
    }
}
