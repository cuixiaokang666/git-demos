package com.excel.easy2;

import com.alibaba.excel.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DemoServiceImpl implements DemoService{
    public static final String ERR_NAME = "猪猪侠";
    @Override
    public ExcelCheckRsult check(List<DemoData> objects) {
        //成功结果集
        List suc = new ArrayList();
        //错误数组
        List<ExcelCheckErrDto> errDtos = new ArrayList<ExcelCheckErrDto>();
        for(DemoData demoData : objects){
            StringBuilder err = new StringBuilder();
            if(ERR_NAME.equals(demoData.getName())) {
                err.append("请输入正确的名字").append(";");
                if (StringUtils.isEmpty(err.toString())) {
                    suc.add(demoData);
                } else {
                    errDtos.add(new ExcelCheckErrDto(demoData, err.toString()));
                }
            }
        }
        return new ExcelCheckRsult(suc,errDtos);
    }
}
