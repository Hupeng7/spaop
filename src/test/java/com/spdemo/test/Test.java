package com.spdemo.test;

import com.spdemo.AopApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hp
 * @version 1.0
 * @description: ${description}
 * 在SpringBoot里添加单元测试
 * 只需要添加SpringBoot单元测试的依赖jar，
 * 和两个注解。
 * @RunWith和@SprintBootTest这两个注解上都有@Inherited这个注解，
 * 所以我们可以定义一个单元测的父类，然后所有的单元测试类继承这个父类就行了
 *
 * @date: 15:39 2018/9/28 0028
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AopApplicationTest.class)
@Slf4j
public class Test {

    @org.junit.Test
    public void testSys() {
        log.info("hello test");
        System.out.println("hello test one");
    }


}
