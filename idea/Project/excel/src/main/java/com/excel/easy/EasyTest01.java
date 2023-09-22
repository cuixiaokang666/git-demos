package com.excel.easy;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
public class EasyTest01 {

    @Test
    public void testEasy03(){
        long stat = System.currentTimeMillis();
        String file = "D:/abc.xls";
        List<Dap> list = new ArrayList<>();
        for(int i=0;i<65500;i++){
            Dap dap = new Dap();
            dap.setId(i+1);
            list.add(dap);
        }
        EasyExcel.write(file,Dap.class).sheet("第一页").doWrite(list);
        long end = System.currentTimeMillis();
        System.out.println("Easy03版写出数据用时:"+(end - stat));
    }

    @Test
    public void testEasy07(){
        long stat = System.currentTimeMillis();
        String file = "D:/abc.xlsx";
        List<Dap> list = new ArrayList<>();
        for(int i=0;i<65500;i++){
            Dap dap = new Dap();
            dap.setId(i+1);
            list.add(dap);
        }
        EasyExcel.write(file,Dap.class).sheet("第一页").doWrite(list);
        long end = System.currentTimeMillis();
        System.out.println("Easy07版写出数据用时:"+(end - stat));
    }
}
