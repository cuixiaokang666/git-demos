package com.sing;

public class Lazybones {
    //创建唯一一个懒汉式单例对象
    private static Lazybones sing;
    //不能让外界直接创建对象,所以设置私有构造器
    private Lazybones(){

    }
    //单例对象的全局访问点
  public static Lazybones getInstance(){
        if(sing == null){
            synchronized (Lazybones.class){
                if(sing == null){
                    sing = new Lazybones();
                }
            }
        }
        return sing;
    }
}
