package com.excel.easy2;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExcelCheckRsult<T> {
    //成功
    private List<T> su;
    //失败
    private List<ExcelCheckErrDto<T>> errDtos;
    public ExcelCheckRsult(List<T> su,List<ExcelCheckErrDto<T>> errDtos){
        this.su = su;
        this.errDtos = errDtos;
    }
    public ExcelCheckRsult(List<ExcelCheckErrDto<T>> errDtos){
        this.su = new ArrayList<T>();
        this.errDtos = errDtos;
    }
}
