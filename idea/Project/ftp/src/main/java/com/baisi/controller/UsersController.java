package com.baisi.controller;

import com.baisi.upload.FileConnParamLoadHelper;
import com.baisi.upload.FileContext;
import com.baisi.upload.SSHParamModel;
import com.jcraft.jsch.SftpException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RestController
public class UsersController {

    @GetMapping("/upload1")
    public String user() throws FileNotFoundException, SftpException {
        File file = new File("D:/data/aa.txt");
        InputStream input = new FileInputStream(file);
        SSHParamModel sshParamModel = FileConnParamLoadHelper.getParamModel();
        FileContext.getSshSession(sshParamModel);
        FileContext.upload(sshParamModel,"养老秘籍",input);
        return "成功";
    }
}
