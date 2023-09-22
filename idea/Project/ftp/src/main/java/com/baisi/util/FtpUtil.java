package com.baisi.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * 工具类
 */
public class FtpUtil {
    //ftp服务器ip地址
    private static final String FTP_ADDRESS = "192.168.154.133";
    //ftp服务器端口号
    private static final int FTP_PORT = 21;
    //ftp服务器用户名
    private static final String FTP_USERNAME =  "cxk";
    //ftp服务器密码
    private static final String FTP_PASSWORD = "cxk1523";
    //附件路径
    private static final String FTP_BASEPATH = "/home/cxk/files";

    /**
     * 上传的文件名称
     * 文件已输入流的方式
     */
    public static boolean uploadFIle(String file, InputStream input){
        //记录上传成功与否
        boolean success = false;
        //创建一个ftp客户端
        FTPClient ftp = new FTPClient();
        try{
            int reply;
            //连接FTP服务器
            ftp.connect(FTP_ADDRESS,FTP_PORT);
            //登录
            ftp.login(FTP_USERNAME,FTP_PASSWORD);
            reply = ftp.getReplyCode();
            //如果没连接上,就断开服务器
            if(!FTPReply.isPositiveCompletion(reply)){
                ftp.disconnect();
                return false;
            }
            //设置文件类型 二进制的文件
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            //创建文件夹
            ftp.makeDirectory(FTP_BASEPATH);
            //设置上传目录
            ftp.changeWorkingDirectory(FTP_BASEPATH);
            //ftp server可能每次开启不同的端口来传输数据
            //但是在linux上,由于安全限制,可能某些端口没有开启,所以就出现组赛
            //所以每次数据连接之前,ftp client告诉ftp server开通一个端口传输数据
            ftp.enterLocalPassiveMode();
            //存文件,返回值为true,则文件上传成功
            boolean b = ftp.storeFile(file,input);
            System.out.println(b);
            //获取响应状态
            System.out.println(ftp.getReplyString());
            //存完之后输入流关闭,ftp客户端注销
            input.close();
            ftp.logout();
            //上传状态为true 上传成功
            success = true;
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(ftp.isConnected()){
                try{
                    ftp.disconnect();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return success;
    }
}
