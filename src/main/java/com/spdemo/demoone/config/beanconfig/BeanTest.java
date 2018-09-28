package com.spdemo.demoone.config.beanconfig;

import org.springframework.context.annotation.Bean;

/**
 * @author hp
 * @version 1.0
 * @description: ${description}
 * @date: 18:21 2018/9/28 0028
 */
public class BeanTest {
    @Bean
    public BeanTest getBean() {
        BeanTest beanTest = new BeanTest();
        System.out.println("调用方法: " + beanTest);
        return beanTest;
    }


}
