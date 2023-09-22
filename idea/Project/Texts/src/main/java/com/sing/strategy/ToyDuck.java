package com.sing.strategy;

public class ToyDuck extends Duck{
    //显示鸭子信息
    @Override
    public void display() {
        System.out.println("这是玩具鸭");
    }
    //因为玩具鸭不能游泳,所以重写swimming
//    public void swimming(){
//        System.out.println("玩具鸭不能游泳");
//    }
    //因为玩具鸭不能叫,所以重写cry
    public void cry(){
        System.out.println("玩具鸭不能叫");
    }
    //初始化游泳模式
    public ToyDuck(){
        flyBehavior = new NoFlyBehavior();
    }
}
