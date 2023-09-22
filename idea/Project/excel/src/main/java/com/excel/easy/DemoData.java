package com.excel.easy;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import java.util.Date;

@Data
public class DemoData {
    @ExcelProperty(value = "编号",index = 0)
    private int id;
    @ExcelProperty(value = "名称",index = 1)
    private String name;
    @ExcelProperty(value = "年龄",index = 2)
    private int age;
    @ExcelProperty(value = "日期",index = 3)
    private Date rq;

    @ExcelIgnore
    private int password;

}
