package com.sing.adapter2;

import com.sing.adapter.Charge;
import com.sing.adapter.Socked;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//对象适配器模式
public class ChargerObjectAdapter implements Socked {
    //声明要使用的对象
    private Charge charge;

    //实例化Charge对象
    public ChargerObjectAdapter(Charge charge){
        this.charge = charge;
    }

    //重新配置连接功能
    @Override
    public void connect() {
        System.out.println("用三个孔的插头进行连接2");
    }

    //重新配置充电功能
    @Override
    public void charge() {
        charge.charge();
    }

    public static void main(String[] args) {
        //对象适配器
        Charge charge = new Charge();
        ChargerObjectAdapter adapter = new ChargerObjectAdapter(charge);
        adapter.connect();
        adapter.charge();
    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                System.out.println("喝热水能治百病？");
//            }
//        });
//    }
}
