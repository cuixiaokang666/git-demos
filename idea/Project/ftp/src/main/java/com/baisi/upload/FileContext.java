package com.baisi.upload;

import com.jcraft.jsch.*;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FileContext {
    //连接session
    private static Session session;
    //连接通道
    private static ChannelSftp sftp;
    //sshSession 启动时完成初始化工作
    //ConcurrentHashMap 线程安全的容器
    private static ConcurrentHashMap<SSHParamModel,Session> sshSessionPool = null;

    private static Set<SSHParamModel> sshParamModelSet = null;

    public FileContext(SSHParamModel sshParam){
        synchronized (FileContext.class){
            if(sshParamModelSet == null){
                sshParamModelSet = new HashSet<>();
            }
            sshParamModelSet.add(sshParam);
            if(sshSessionPool == null){
                sshSessionPool = new ConcurrentHashMap<>();
                for(SSHParamModel sshParamModel : sshParamModelSet){
                    session = getSessionConnection(sshParamModel);
                    sshSessionPool.put(sshParamModel,session);
                }
            }else{
                System.out.println("--------");
            }
        }
    }
    private static Session getSessionConnection(SSHParamModel sshParamModel){
        try{
            JSch jsch = new JSch();
            session = jsch.getSession(sshParamModel.getUsername(),sshParamModel.getHost(),sshParamModel.getPort());
            if(sshParamModel.getPassword() != null){
                session.setPassword(sshParamModel.getPassword());
            }
            Properties config = new Properties();
            config.put("StrictHostKeyChecking","no");
            session.setConfig(config);
            session.connect();
            Channel channel = session.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
        }catch (JSchException e){
            e.printStackTrace();
        }
        return session;
    }
    public static void upload(SSHParamModel sshParamModel, String sftpFileName, InputStream input) throws SftpException {
        String basePath = sshParamModel.getBasePath();
        String directory = sshParamModel.getDirectory();
        try{
            sftp.cd(basePath);
            sftp.cd(directory);
        }catch (SftpException e){
            //目录不存在,则创建文件夹
            String[] dirs = directory.split("/");
            String temPath = basePath;
            for(String dir : dirs){
                if(null == dir || "".equals(dir)) continue;
                temPath += "/" + dir;
                try{
                    sftp.cd(temPath);
                }catch (SftpException e1){
                    System.out.println(temPath);
                    sftp.mkdir(temPath);
                    sftp.cd(temPath);
                }
            }
        }
        sftp.put(input,sftpFileName);
    }
    public static void getSshSession(SSHParamModel paramModel){
        Session currSession = sshSessionPool.get(paramModel);
        synchronized (FileContext.class){
            if(currSession == null || !currSession.isConnected()){
                if(sshSessionPool.containsKey(paramModel)){
                    currSession = getSessionConnection(paramModel);
                    sshSessionPool.put(paramModel,currSession);
                }else{
                    System.out.println("--------");
                }
            }
        }
    }
}
