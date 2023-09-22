package com.excel.easy;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Dap {
    @ExcelProperty(value = "编号",index = 0)
    private int id;
}
