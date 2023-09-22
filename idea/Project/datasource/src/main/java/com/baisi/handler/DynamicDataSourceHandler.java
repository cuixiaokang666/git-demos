package com.baisi.handler;

//引入ThreadLocal类,解决线程不安全问题
public class DynamicDataSourceHandler {

    private static final ThreadLocal<String> DAT = new ThreadLocal<>();
    //定义set方法
    public static void setData(String key){
        System.out.println("当前使用的是:"+key);
        DAT.set(key);
    }
    //定义get方法
    public static String getData(){
        return DAT.get();
    }
    //定义删除方法
    public static void removeData(){
        DAT.remove();
    }
}
