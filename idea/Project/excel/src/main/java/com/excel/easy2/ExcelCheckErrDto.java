package com.excel.easy2;

import lombok.Data;

@Data
public class ExcelCheckErrDto<T> {
    //错误数据类型
    private T t;
    //错误提示信息
    private String er;
    //无参构造
    public ExcelCheckErrDto(){
    }
    public ExcelCheckErrDto(T t, String er) {
        this.t = t;
        this.er = er;
    }
}
