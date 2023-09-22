package com.sing.strategy;

public class WildDuck extends Duck{
    //显示鸭子信息
    @Override
    public void display() {
        System.out.println("这是一只野鸭子");
    }
    //初始化游泳行为
    public WildDuck(){
        flyBehavior = new GoodFlyBehavior();
    }
}
