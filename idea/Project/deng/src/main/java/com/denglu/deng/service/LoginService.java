package com.denglu.deng.service;

import com.denglu.deng.model.User;

import java.util.Map;

public interface LoginService {
    Map<String,Object> login(User user);
}
