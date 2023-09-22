package com.baisi.security.entity;
import lombok.Data;

/**
 * 用户实现类
 */
@Data
public class User {
    //主键 id
    private Integer id;
    //用户名
    private String username;
    //电话
    private String telephone;
    //邮箱
    private String mail;
    //密码
    private String password;
    //用户状态
    private long status;
}
