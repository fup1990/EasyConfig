package com.gome.fup.easyconfig;

import com.gome.fup.easyconfig.util.EasyConfigUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * Created by fupeng-ds on 2017/7/27.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        DemoController demo = context.getBean(DemoController.class);
        System.out.println("before change:" + demo.getStr());
        //通过server修改配置信息
        Thread.sleep(5000l);
        System.out.println("after change:" + demo.getStr());
    }
}
