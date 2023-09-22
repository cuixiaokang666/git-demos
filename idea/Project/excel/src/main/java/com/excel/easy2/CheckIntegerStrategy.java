package com.excel.easy2;

/**
 * 校验年龄规则
 * @param <T>
 */
public class CheckIntegerStrategy<T> extends CheckStrategy<T> {

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
     * 校验用户年龄
     * @param demoData
     * @return
     */
    private String chen(DemoData demoData){
        return Integer.valueOf(demoData.getAge())>100 ? "年龄太大了,请重新输入" : "";
    }
}
