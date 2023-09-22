package com.denglu.deng.strategy;

import com.denglu.deng.model.User;
import com.denglu.deng.model.UserState;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 正常登录状态返回结果
 */
@LoginState(useState = UserState.VALID)
public class ValidStrategy implements LoginStrategy{
    @Autowired
    private HttpSession session;
    @Override
    public Map<String, Object> doMap(User dbUser,HttpSession session) {
        session.setAttribute("loginUser", dbUser);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("msg",UserState.VALID.getMessage());
        return resultMap;
    }
}
