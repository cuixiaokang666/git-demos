package com.excel.easy2;

/**
 * 校验姓名规则
 * @param <T>
 */
public class CheckStringStrategy<T> extends CheckStrategy<T>{

    /**
     * 实现校验规则
     * @param t
     * @return
     */
    @Override
    protected String chen(T t) {
        return t instanceof DemoData ? chen((DemoData) t) : "";
    }

    /**
     * 校验用户名字
     * @param demoData
     * @return
     */
    private String chen(DemoData demoData){
        return "猪猪侠".equals(demoData.getName()) ? "不可以叫猪猪侠,不是人的名字" : "";
    }
}
