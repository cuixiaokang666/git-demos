package com.excel.easy2;

import java.util.List;

public interface ExcelCheckManager<T> {
    //校验方法
    ExcelCheckRsult check(List<T> objects);
}
