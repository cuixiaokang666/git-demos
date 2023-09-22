package com.sing.Proxys;

import com.sing.service.DapService;
import com.sing.service.DapServiceImpl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyJdk {
    //声明目标对象
    private Object tar;
    //实现目标对象
    public ProxyJdk(Object tar){
        this.tar = tar;
    }

    //获取代理对象

    public Object getTar() {
        //newProxyInstance的三个参数
        //第一个参数是该类的类加载器
        //第二个是需要代理实例的接口列表,因为该原因,所以,实例必须要有接口 目标对象的接口集
        //第三个参数不能为空,代理对象的所有方法调用都被委托到 invoke 方法
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(),
                tar.getClass().getInterfaces(),new InvocationHandler(){
            public Object invoke(Object object, Method method,Object[] args) throws Throwable {
                System.out.println("在原有的方法之前写代码------判断是否是离职人员入职1");
                Object invoke = method.invoke(tar,args);
                System.out.println("在原有的方法之后写代码------发送短信1");
                return invoke;
            }
        });
    }

    public static void main(String[] args) {
        // Jdk动态代理
        DapService dapService = new DapServiceImpl();
        ProxyJdk proxyJdk = new ProxyJdk(dapService);
        // 获取代理对象
        Object object = proxyJdk.getTar();
        if(object instanceof DapService){
            ((DapService) object).add();
    }
    }
}
