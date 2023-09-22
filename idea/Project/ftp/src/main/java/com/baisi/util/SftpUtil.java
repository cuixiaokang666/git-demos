package com.baisi.util;

import com.jcraft.jsch.*;
import org.apache.commons.io.IOUtils;
import java.io.*;
import java.util.Properties;
import java.util.Vector;

/**
 * sftp工具类
 */
public class SftpUtil {
    //连接通道
    private ChannelSftp sftp;
    //连接Session
    private Session session;
    //用户名
    private String username;
    //密码
    private String password;
    //私钥
    private String privateKey;
    //ip地址
    private String host;
    //端口
    private int port;

    /**
     * 构造基于密码认证的sftp对象
     * @param username
     * @param password
     * @param host
     * @param port
     */
    public SftpUtil(String username,String password,String host,int port){
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    /**
     * 构造基于密码认证的sftp对象
     * @param username
     * @param host
     * @param port
     * @param privateKey
     */
    public SftpUtil(String username,String host,int port,String privateKey){
        this.username = username;
        this.host = host;
        this.port = port;
        this.privateKey = privateKey;
    }

    /**
     * 无参构造
     */
//    public SftpUtil(){
//    }

    /**
     * 连接sftp服务器
     */
    public void login(){
        try{
            JSch jSch = new JSch();
            if(privateKey != null){
                jSch.addIdentity(privateKey);//设置私钥
            }
            session = jSch.getSession(username,host,port);
            if(password != null){
                session.setPassword(password);
            }
            Properties con = new Properties();
            con.put("StrictHostKeyChecking","no");
            session.setConfig(con);
            session.connect();
            Channel channel = session.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
        }catch (JSchException e){
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接 server
     */
    public void logout(){
        if(sftp != null){
            if(sftp.isConnected()){
                sftp.disconnect();
            }
        }
        if(session != null){
            if(session.isConnected()){
                session.disconnect();
            }
        }
    }

    /**
     * 将输入流的数据上传到sftp作为文件,文件完整路径=basePath+directory
     * @param basePath 服务器的基本路径
     * @param directory 上传到该目录
     * @param sftpFileName sftp端文件名
     * @param input 输入流
     * @throws SftpException
     */
    public void upload(String basePath, String directory, String sftpFileName, InputStream input) throws SftpException {
            try{
                sftp.cd(basePath);
                sftp.cd(directory);
            }catch (SftpException e){
            //目录不存在,则创建文件夹
            String [] dirs = directory.split("/");
            String temPath = basePath;
            for(String dir : dirs){
                if(null == dir || "".equals(dir)) continue;
                temPath += "/" + dir;
                try{
                    sftp.cd(temPath);
                }catch (SftpException ex){
                    sftp.mkdir(temPath);
                    sftp.cd(temPath);
                }
            }
        }
        sftp.put(input,sftpFileName);//上传文件
    }

    /**
     *下载文件
     * @param directory 下载目录
     * @param downloadFile 下载文件
     * @param saveFile 存在本地的路径
     * @throws SftpException
     * @throws FileNotFoundException
     */
    public void download(String directory,String downloadFile,String saveFile) throws SftpException, FileNotFoundException {
        if(directory != null && !"".equals(directory)){
            sftp.cd(directory);
        }
        File file = new File(saveFile);
        sftp.get(downloadFile,new FileOutputStream(file));
    }

    /**
     *下载文件
     * @param directory 下载目录
     * @param downloadFile 下载的文件
     * @return
     * @throws SftpException
     * @throws IOException
     */
    public byte[] download(String directory,String downloadFile) throws SftpException, IOException {
        if(directory != null && !"".equals(directory)){
            sftp.cd(directory);
        }
        InputStream is = sftp.get(downloadFile);
        byte[] fileData = IOUtils.toByteArray(is);
        return fileData;
    }

    /**
     * 删除文件
     * @param directory 删除文件所在的目录
     * @param deleteFile 要删除的文件
     * @throws SftpException
     */
    public void delete(String directory,String deleteFile) throws SftpException {
        sftp.cd(directory);
        sftp.cd(deleteFile);
    }

    /**
     * 列出目录下的文件
     * @param
     * @return
     * @throws SftpException
     */
    public Vector<?> listFiles(String directory) throws SftpException {
        return sftp.ls(directory);
    }


    public static void main(String[] args) throws FileNotFoundException, SftpException {
        SftpUtil sftpUtil = new SftpUtil("root","cxk1523","192.168.154.144",22);
        sftpUtil.login();
        //上传文件测试
        File file = new File("D://data//aa.txt");
        InputStream is = new FileInputStream(file);
        sftpUtil.upload("/sftp/mysftp/upload","养生","多喝水",is);
        sftpUtil.logout();
        System.out.println("上传成功");
    }
}
