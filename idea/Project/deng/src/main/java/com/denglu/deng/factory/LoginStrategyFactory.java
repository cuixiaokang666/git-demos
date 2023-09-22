package com.denglu.deng.factory;

import com.denglu.deng.strategy.LoginStrategy;

import java.util.List;

public class LoginStrategyFactory {
    //声明装策略的容器
    public static List<LoginStrategy> strategies;
    //构造方法实例化
    public LoginStrategyFactory(List<LoginStrategy> strategies){
        LoginStrategyFactory.strategies = strategies;
    }
}
