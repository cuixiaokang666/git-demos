package com.denglu.deng.strategy;

import com.denglu.deng.model.User;
import com.denglu.deng.model.UserState;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常登录策略
 */
@LoginState(useState = UserState.ABNORMAL)
public class AbnormalStrategy implements LoginStrategy{
    @Override
    public Map<String, Object> doMap(User dbUser, HttpSession session) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("msg", UserState.ABNORMAL.getMessage());
        return resultMap;
    }
}
