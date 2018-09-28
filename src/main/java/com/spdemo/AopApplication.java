package com.spdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * @author hp
 * @EnableConfigurationProperties 开启自定义配置属性扫描
 * @ComponentScan 托管类扫描路径
 */
@ComponentScan(basePackages = {"com.spdemo.demoone"})
@SpringBootApplication
public class AopApplication implements EmbeddedServletContainerCustomizer {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class);
    }


    /**
     * 实现接口 重写方法  目的是为了修改端口号
     *
     * @param configurableEmbeddedServletContainer
     */
    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(8001);
    }
}
