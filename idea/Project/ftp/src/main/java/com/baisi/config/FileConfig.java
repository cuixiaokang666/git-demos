package com.baisi.config;

import com.baisi.upload.FileConnParamLoadHelper;
import com.baisi.upload.FileContext;
import com.baisi.upload.SSHParamModel;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileConfig {

    @Bean
    @ConfigurationProperties("file.connect.sftp.param")
    public SSHParamModel sshParamModel(){
        return new SSHParamModel();
    }

    @Bean
    public FileConnParamLoadHelper fileConnParamLoadHelper(SSHParamModel sshParamModel){
        return new FileConnParamLoadHelper(sshParamModel);
    }

    @Bean
    public FileContext fileContext(){
        return new FileContext(sshParamModel());
    }
}
