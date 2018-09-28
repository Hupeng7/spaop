package com.spdemo.demoone.controller;

import com.spdemo.demoone.aspect.annotation.UserAccess;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hp
 * @version 1.0
 * @description: ${description}
 * @date: 11:37 2018/9/28 0028
 */
@RestController
@RequestMapping("/aop")
public class FirstController {
    @RequestMapping("/first")
    public Object first() {
        return "first controller";
    }

    @RequestMapping("/doError")
    public Object error() {
        return 1 / 0;
    }

    @RequestMapping("/second")
    @UserAccess(desc = "second1")
    public Object second() {
        return "second controller";
    }


}
