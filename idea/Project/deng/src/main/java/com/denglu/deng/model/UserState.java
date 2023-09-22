package com.denglu.deng.model;

public enum UserState {
    VALID("正常"),
    LEAVE("离职"),
    NOMENU("没有菜单"),
    ABNORMAL("用户状态异常"),
    UNREGISTER("未注册"),
    INCORRENT("密码不正确");

    //用户信息状态
    String message;

    UserState(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
