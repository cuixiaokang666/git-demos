package com.denglu.deng.strategy;
import com.denglu.deng.model.User;
import javax.servlet.http.HttpSession;
import java.util.Map;

public interface LoginStrategy {
    Map<String,Object> doMap(User dbUser, HttpSession session);
}
