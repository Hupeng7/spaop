package com.spdemo.demoone.config.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hp
 * @version 1.0
 * @description: ${description}
 * @date: 17:57 2018/9/28 0028
 */
@Configuration
public class AppConfig {

    @Bean(initMethod = "init")
    public Foo getFoo() {
        return new Foo();
    }

    @Bean(destroyMethod = "cleanup")
    public Bar getBar() {
        return new Bar();
    }


}
