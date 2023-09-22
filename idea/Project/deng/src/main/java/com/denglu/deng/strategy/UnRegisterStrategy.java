package com.denglu.deng.strategy;

import com.denglu.deng.model.User;
import com.denglu.deng.model.UserState;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 未注册登录策略
 */
@LoginState(useState = UserState.UNREGISTER)
public class UnRegisterStrategy implements LoginStrategy{
    @Override
    public Map<String, Object> doMap(User dbUser, HttpSession session) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("msg", UserState.UNREGISTER.getMessage());
        return resultMap;
    }
}
