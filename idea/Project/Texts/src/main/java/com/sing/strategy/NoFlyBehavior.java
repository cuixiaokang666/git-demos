package com.sing.strategy;

public class NoFlyBehavior implements FlyBehavior{
    @Override
    public void swimming() {
        System.out.println("没有游泳能力");
    }
}
