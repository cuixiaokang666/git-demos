package com.excel.easy2;

import com.alibaba.excel.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 校验数据策略父类
 * @param <T>
 */
public abstract class CheckStrategy<T> {

    public List<ExcelCheckErrDto<T>> check(List<T> objects){
        //定义错误数据结果集
        List<ExcelCheckErrDto<T>> errDto = new ArrayList<>();
        //循环数据,编写自己的过滤业务
        for(int i = 0, len = objects.size(); i<len; i++){
            T obj = objects.get(i);
            //定义错误提示信息
            String err  = chen(obj);
            //如果没有错误信息,则校验成功,将数据添加到校验成功的结果集
            if(StringUtils.isEmpty(err)){
            }else{
                errDto.add(new ExcelCheckErrDto<>(obj,err));
                //过滤出错误数据,就将其删除
                //避免下一个过滤器重复过滤
                objects.remove(obj);
                --len;
                --i;
            }
        }
        return errDto;
    }
    //自定义抽象规则
    protected abstract String chen(T t);
}
