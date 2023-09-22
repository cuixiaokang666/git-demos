package com.baisi.upload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SSHParamModel {
    //端口号
    private int port;
    //ip地址
    private String host;
    //用户名
    private String username;
    //密码
    private String password;
    //服务器基础路径
    private String basePath;
    //上传目录
    private String directory;
}
