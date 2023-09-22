package com.denglu.deng.config;

import com.denglu.deng.factory.LoginStrategyFactory;
import com.denglu.deng.strategy.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置类
 */
@Configuration
public class LoginConfig {

    @Bean
    public LoginStrategyFactory getStrategyFactory(){
        List<LoginStrategy> strategies = new ArrayList<>();
        strategies.add(new UnRegisterStrategy());
        strategies.add(new IncorrentStrategy());
        strategies.add(new AbnormalStrategy());
        strategies.add(new LeaveStrategy());
        strategies.add(new NoMenuStrategy());
        strategies.add(new ValidStrategy());
        return new LoginStrategyFactory(strategies);
    }
}
