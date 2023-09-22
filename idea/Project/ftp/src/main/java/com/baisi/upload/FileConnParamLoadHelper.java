package com.baisi.upload;

public class FileConnParamLoadHelper {
    //声明连接参数模型
    private static SSHParamModel paramModel = null;

    public FileConnParamLoadHelper(SSHParamModel sshParamModel){
        FileConnParamLoadHelper.paramModel = sshParamModel;
    }

    //获取连接参数模型
    public static SSHParamModel getParamModel(){
        return paramModel;
    }
}
