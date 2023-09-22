package com.baisi.aop;
import com.baisi.handler.DynamicDataSourceHandler;
import com.baisi.note.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

//实现aop增强
@Aspect
@Component
public class DataSourceAop {

    //定义环绕
    @Around("execution(* com.baisi.Mapper.*Mapper.*(..))")
    public Object surround(ProceedingJoinPoint point){
        //前置增强
        //获取方法签名
        Signature signature = point.getSignature();
        MethodSignature ms = (MethodSignature)signature;
        //获取目标方法的对象
        Method method = ms.getMethod();
        DataSource ann = method.getAnnotation(DataSource.class);
        //进行空值判断
        if(ann == null){
            //注释到方法上
            Class declaringType = signature.getDeclaringType();
            ann = (DataSource)(declaringType.getAnnotation(DataSource.class));
        }
        String key = ann.value().name();
        DynamicDataSourceHandler.setData(key);
        //执行目标方法
        Object res = null;
        try {
            res = point.proceed();
        } catch (Throwable throwable) {
            System.out.println("目标方法抛出异常");
            throwable.printStackTrace();
        }finally {
            DynamicDataSourceHandler.removeData();
        }
        //后置增强
        return res;
    }
}
