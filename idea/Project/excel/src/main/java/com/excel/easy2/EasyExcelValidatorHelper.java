package com.excel.easy2;

import com.alibaba.excel.annotation.ExcelProperty;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.lang.reflect.Field;
import java.util.Set;

public class EasyExcelValidatorHelper {
    //实例化校验对象
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    //私有构造器
    private EasyExcelValidatorHelper(){
    }
    //校验数据
    public static <T> String valid(T obj) throws NoSuchFieldException{
        //创建result储存的错误信息
        StringBuilder result = new StringBuilder();
        //拿到返回错误的数据集合
        Set<ConstraintViolation<T>> set = validator.validate(obj,Default.class);
        //如果set集合有数据,证明有错误信息,循环取出
        if(set != null && !set.isEmpty()){
            for(ConstraintViolation<T> cv : set){
                //通过反射获取错误信息的属性对象
                Field de = obj.getClass().getDeclaredField(cv.getPropertyPath().toString());
                //拿到错误属性的注解value
                ExcelProperty annotation = de.getAnnotation(ExcelProperty.class);
                //将拿到是错误信息和提示存入result
                result.append(annotation.value()[0]+cv.getMessage()).append(";");
            }
        }
        //返回错误信息
        return result.toString();
    }
}
