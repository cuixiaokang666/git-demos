package com.denglu.deng.controller;

import com.denglu.deng.model.User;
import com.denglu.deng.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    //跳转登录页面
    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    //登录接口
    @PostMapping("/login")
    public String login(User user, ModelMap map){
       //调用service 层完成登录功能
        Map<String,Object> resultMap = loginService.login(user);
       if(resultMap != null){
            map.put("result",resultMap);
       }
       return "index";
    }
}
