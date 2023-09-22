package com.denglu.deng.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    /* 用户状态
     * 1 表示 正常
     * 2 表示 状态异常
     * 3 表示 离职
     * 4 表示 没有任何菜单权限
     * */
    private String state;
}
