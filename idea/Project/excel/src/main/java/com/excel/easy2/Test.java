package com.excel.easy2;

import com.alibaba.excel.EasyExcelFactory;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        String file = "D:/abc.xls";
//        DemoListener demoListener = new DemoListener(DemoData.class);
//        EasyExcelFactory.read(file,DemoData.class,demoListener).sheet().doRead();
//        System.out.println("==========错误信息==========");
//        List<ExcelCheckErrDto<DemoData>> errList = demoListener.getErrList();
//        if(!errList.isEmpty()) {
//            for(ExcelCheckErrDto<DemoData> demo : errList){
//                System.out.println(demo);
//            }
//        }
//        System.out.println("==========正确数据==========");
//        List list  = demoListener.getList();
//        for(Object o : list){
//            System.out.println(o);
//        }

        String file = "D:/abc.xls";
        DemoListener demoListener = new DemoListener(DemoData.class);
        EasyExcelFactory.read(file,DemoData.class,demoListener).sheet().doRead();
        System.out.println("==========错误数据==========");
        List<ExcelCheckErrDto<DemoData>> errDtos = demoListener.getErrDtos();
        if(!errDtos.isEmpty()){
            errDtos.forEach(System.out::println);
        }
        System.out.println("==========正确数据==========");
        List list = demoListener.getLists();
        if(!list.isEmpty()){
           list.forEach(System.out::println);
        }
    }
}
