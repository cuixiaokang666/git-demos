package com.denglu.deng.service;

import com.denglu.deng.dao.UserMapper;
import com.denglu.deng.factory.LoginStrategyFactory;
import com.denglu.deng.model.User;
import com.denglu.deng.model.UserState;
import com.denglu.deng.strategy.LoginState;
import com.denglu.deng.strategy.LoginStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.denglu.deng.model.AppConstant.*;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private HttpSession session;
    @Autowired
    private UserMapper userMapper;

    public Map<String, Object> login(User user) {
        //查询用户信息
        User dbuser = userMapper.getByUsername(user.getUsername());
        //判断用户状态
        UserState state = checkUserState(dbuser,user.getPassword());
        //根据用户状态进行相应的操作,这些相应的操作,我们把它定义成方法
        List<LoginStrategy> strategies = LoginStrategyFactory.strategies;
        for(LoginStrategy strategy:strategies){
            LoginState annotation = strategy.getClass().getAnnotation(LoginState.class);
            if(state.equals(annotation.useState())){
                return strategy.doMap(dbuser,session);
            }
        }
        return null;
    }
    //检验用户状态
    private UserState checkUserState(User dbuser, String password) {
        //如果user为空,用户状态未注册
        if(dbuser == null){
            return UserState.UNREGISTER;
        }
        //如果密码不正确,返回密码不正确的状态
        if(!password.equals(dbuser.getPassword())){
            return UserState.INCORRENT;
        }
        //如果用户状态为1,表示用户状态正常
        if(LOGIN_STATE_VALID.equals(dbuser.getState())){
            return UserState.VALID;
        }
        //如果用户状态为2,表示用户状态异常
        if(LOGIN_STATE_ABNORMAL.equals(dbuser.getState())){
            return UserState.ABNORMAL;
        }
        //如果用户状态为3,表示用户已离职
        if(LOGIN_STATE_LEAVE.equals(dbuser.getState())){
            return UserState.LEAVE;
        }
        return UserState.NOMENU;
    }
}
