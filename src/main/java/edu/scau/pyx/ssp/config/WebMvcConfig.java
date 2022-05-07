package edu.scau.pyx.ssp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")   //所有方法都做处理跨域
                .allowedHeaders("*")  //允许的请求头
                .allowedMethods("*")  //允许通过地请求方法
                //.allowedOrigins("*")  //允许跨域的请求头
                .allowedOriginPatterns("*")//允许跨域的请求头
                .allowCredentials(true);//允许携带cookie参数
    }
}
