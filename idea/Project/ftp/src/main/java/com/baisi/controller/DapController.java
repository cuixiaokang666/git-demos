package com.baisi.controller;

import com.baisi.util.FtpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 用户控制器描述
 */
@Controller
public class DapController {

    @PostMapping("/dap")
    public String add(String dap, @RequestParam("headPic") MultipartFile file) throws IOException {
        //获取上传的文件流
        InputStream inputStream = file.getInputStream();
        //获取上传的文件名
        String fileName = file.getOriginalFilename();
        //截取后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //使用UUID凭借后缀,定义一个不重复的文件名
        String finalName = UUID.randomUUID() + suffix;
        //调用自定义的FTP工具类上传文件
        boolean flag = FtpUtil.uploadFIle(fileName,inputStream);
        System.out.println(dap + "上传文件:" + flag);
        return "sut";
    }
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
