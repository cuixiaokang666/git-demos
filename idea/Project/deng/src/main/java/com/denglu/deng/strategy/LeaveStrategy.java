package com.denglu.deng.strategy;

import com.denglu.deng.model.User;
import com.denglu.deng.model.UserState;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 离职登录策略
 */
@LoginState(useState = UserState.LEAVE)
public class LeaveStrategy implements LoginStrategy{
    @Override
    public Map<String, Object> doMap(User dbUser, HttpSession session) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("msg", UserState.LEAVE.getMessage());
        return resultMap;
    }
}
