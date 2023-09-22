package com.sing.strategy;

/**
 * 鸭子抽象父类
 */
public abstract class Duck {
    //聚合游泳行为策略接口
    protected FlyBehavior flyBehavior;
    //显示鸭子的信息
    public abstract void display();
    //鸭子行为
    public void swimming(){
        if(flyBehavior != null){
            flyBehavior.swimming();
        }
    }
    //鸭子行为
    public void cry(){
        System.out.println("鸭子会叫");
    }
}
