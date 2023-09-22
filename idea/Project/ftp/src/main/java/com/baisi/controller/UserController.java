package com.baisi.controller;

import com.baisi.upload.FileConnParamLoadHelper;
import com.baisi.upload.FileContext;
import com.baisi.upload.SSHParamModel;
import com.jcraft.jsch.SftpException;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RestController
public class UserController {

    @GetMapping("/user")
    public String upload() throws FileNotFoundException, SftpException {
        //测试,将aaa.txt上传到文件服务器
        File file = new File("D:/data/aa.txt");
        InputStream is = new FileInputStream(file);
        //拿到连接 model 去获取session
        SSHParamModel paramModel = FileConnParamLoadHelper.getParamModel();
        //根据连接 model 去获取session
        FileContext.getSshSession(paramModel);
        //上传
        FileContext.upload(paramModel,"终极养老",is);
        return "成功";
    }
}