package com.excel.easy2;

public class ExcelPatterMsg {
    private ExcelPatterMsg(){
    }
    //只能输入小数或者整数
    public static final String DECIMAL = "^[0-9]+\\.{0,1}[0-9]{0,2}$";
    public static final String DECIMAL_MSG = "只能输入整数,不能为空";
    //数字
    public static final String NUMBER = "^[0-9]*$";
    public static final String NUMBER_MSG = "只能输入数字";
}
