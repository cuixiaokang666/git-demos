package com.sing.strategy;

public class PekingDuck extends Duck{
    //显示鸭子信息
    @Override
    public void display() {
        System.out.println("这是一只北京鸭");
    }
    //这是一只北京鸭不能游泳,所以重写swimming
//    public void swimming(){
//        System.out.println("北京鸭不能游泳");
//    }
    //初始化游泳行为
    public PekingDuck(){
        flyBehavior = new BadFlyBehavior();
    }
}
