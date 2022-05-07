package edu.scau.pyx.ssp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//mvc配置
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /*使用Mvc配置解决前后端跨越问题*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//设置允许跨域的路径
                .allowedOrigins("http://127.0.0.1:8000")//允许指定前端的请求跨域，传cookie不能*
                .allowedHeaders("*")//允许的请求头
                .allowedMethods("*")//允许请求的方法，get、post、put....
                .allowCredentials(true);//使用凭证
    }
}