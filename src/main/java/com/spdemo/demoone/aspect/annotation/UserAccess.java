package com.spdemo.demoone.aspect.annotation;

import java.lang.annotation.*;

/**
 * @author hp
 * @version 1.0
 * @description: ${description}
 * @date: 14:16 2018/9/28 0028
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserAccess {
    String desc() default "无信息";

    //String value() default "";
}
