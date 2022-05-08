package edu.scau.pyx.ssp.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;
import java.io.File;

@Configuration
public class MultipartConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        String path = System.getProperty("user.dir")+"/files";
        File tmpFile = new File(path);    // 如果临时目录不存在则创建
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }
        // 明确指定上传文件的临时目录
        factory.setLocation(path);
        return factory.createMultipartConfig();
    }
}
