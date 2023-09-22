package com.sing.adapter;

public interface Socked {
    //连接功能
   default void connect(){
       System.out.println("用两个孔的插头进行连接");
   }

    void charge();
}
