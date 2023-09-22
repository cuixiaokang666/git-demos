package com.excel.easy;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EasyTest {
    public static void main(String[] args) {
        String file = "D:/abc.xls"  ;

        //创建List,添加数据
        List<DemoData> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            DemoData demoData = new DemoData();
            demoData.setId(i+1);
            demoData.setName("张三");
            demoData.setAge(10+i);
            demoData.setRq(new Date());
            list.add(demoData);
        }
        //写出
        EasyExcel.write(file,DemoData.class).sheet("第一页").doWrite(list);
        System.out.println("over");
    }
}
