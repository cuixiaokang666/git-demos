package com.sing.Proxys;

import com.sing.service.DapService;
import com.sing.service.DapServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyCglib implements MethodInterceptor {

    //声明动态代理对象
    private Object tar;
    //实例化代理对象
    public ProxyCglib(Object tar){
        this.tar = tar;
    }
    //代理功能扩展
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("在原有方法之前写代码------判断是否是离职人员入职2");
        Object invoke = method.invoke(tar,objects);
        System.out.println("在原有方法之后写代码------发送短信2");
        return invoke;
    }
    //获取代理对象
    public Object getTar(){
        //Enhancer允许为非接口类型创建一个java代理
        //Enhancer动态创建了给定类型的子类但是拦截了所有的方法
        //和Proxy不一样的是,不管是接口还是类他都能正常工作
        Enhancer enhancer = new Enhancer();
        //设置代理类字节码,不需要获取接口
        enhancer.setSuperclass(tar.getClass());
        //设置回调,需要传递当前对象
        enhancer.setCallback(this);
        //创建代理对象并返回
        return enhancer.create();
    }

    public static void main(String[] args) {
        //cglib动态代理
        DapService dapService = new DapServiceImpl();
        ProxyCglib proxyCglib = new ProxyCglib(dapService);
        //获取代理对象
        Object object = proxyCglib.getTar();
        if(object instanceof DapServiceImpl){
            ((DapService) object).add();
        }
    }
}
