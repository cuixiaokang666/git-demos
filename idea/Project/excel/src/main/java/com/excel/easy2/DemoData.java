package com.excel.easy2;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

@Data
public class DemoData {
    //id
    //@Pattern(regexp = ExcelPatterMsg.DECIMAL,message = ExcelPatterMsg.DECIMAL_MSG)
    @ExcelProperty(value = "编号",index = 0)
    private String id;
    //姓名
    @ExcelProperty(value = "名称",index = 1)
    @Length(max = 5)
    private String name;
    //年龄
    @Pattern(regexp = ExcelPatterMsg.NUMBER,message = ExcelPatterMsg.NUMBER_MSG)
    @ExcelProperty(value = "年龄",index = 2)
    private String age;
}
