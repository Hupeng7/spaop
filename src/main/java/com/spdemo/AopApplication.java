package com.spdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 */
//@EnableConfigurationProperties//开启自定义配置属性扫描
@ComponentScan(basePackages = {"com.spdemo.demoone"})//托管类扫描路径
@SpringBootApplication
public class AopApplication {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class);
    }
}
