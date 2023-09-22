package com.excel.easy;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DemoDataListener extends AnalysisEventListener<DemoData> {
    //储存读到的数据
    private List<DemoData> list = new ArrayList<>();

    /**
     * 一行一行读取
     * @param demoData
     * @param analysisContext
     */
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        System.out.println("*****"+demoData);
        list.add(demoData);
        if(list.size() > 1000){
            //将数据存入数据库中,并清除list
            list.clear();
        }
    }

    /**
     * 读取表头内容
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHeadMap(Map<Integer,String> headMap,AnalysisContext context){
        System.out.println("表头"+headMap);
    }

    /**
     * 确保最后遗留的数据也被储存数据库
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //将数据储存入数据库,并清空list
        list.clear();
    }

    @Test
    public void sim(){
        String file = "D:/abc.xls";
        //这里需要指定用哪个class去读,然后读取第一个sheet
        //然后文件流自动关闭
        EasyExcel.read(file, DemoData.class,new DemoDataListener()).sheet().doRead();
    }
}
