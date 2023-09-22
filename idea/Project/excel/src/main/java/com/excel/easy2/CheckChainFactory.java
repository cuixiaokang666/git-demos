package com.excel.easy2;

import java.util.ArrayList;
import java.util.List;

/**
 * 策略装载工厂
 * @param <T>
 */
public class CheckChainFactory<T> {
    //过滤链
    private List<CheckStrategy<T>> checkStrategyList = new ArrayList<>();

    //构造方法
    public CheckChainFactory(){
        checkStrategyList.add(new CheckIntegerStrategy<>());
        checkStrategyList.add(new CheckStringStrategy<>());
    }

    //获取过滤链
    public List<CheckStrategy<T>> getCheck(){
        return checkStrategyList;
    }

    public void add(ExcelCheckErrDto<T> excelCheckErrDto) {
    }
}
