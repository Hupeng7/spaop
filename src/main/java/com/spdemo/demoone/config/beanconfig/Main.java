package com.spdemo.demoone.config.beanconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hp
 * @version 1.0
 * @description: ${description}
 * @date: 18:23 2018/9/28 0028
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanTest.class);
        Object o = context.getBean("getBean");

        System.out.println(o);

        Object o1 = context.getBean("getBean");
        System.out.println(o1);


    }
}
