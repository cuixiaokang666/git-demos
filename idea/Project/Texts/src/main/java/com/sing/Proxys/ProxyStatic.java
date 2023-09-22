package com.sing.Proxys;

import com.sing.service.DapService;
import com.sing.service.DapServiceImpl;

public class ProxyStatic implements DapService {

    // 需要扩展的目标对象
    private DapService dapService;
    //实例化DapService对象
    public ProxyStatic(DapService dapService){
        this.dapService = dapService;
    }
    //扩展功能的方法
    public void add() {
        System.out.println("在原有的方法之前写代码-------判断是否是离职人员入职");
        //原有的功能不能修改
        dapService.add();
        System.out.println("在原有的方法之后写代码-------发送短息");
    }

    public static void main(String[] args) {
        // 静态代理
        DapService dapService = new DapServiceImpl();
        ProxyStatic proxyStatic = new ProxyStatic(dapService);
        proxyStatic.add();
    }
}
