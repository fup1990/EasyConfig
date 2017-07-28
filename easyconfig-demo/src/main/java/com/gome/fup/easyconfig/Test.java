package com.gome.fup.easyconfig;

import com.gome.fup.easyconfig.util.EasyConfigUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * Created by fupeng-ds on 2017/7/27.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        EasyConfigUtil util = context.getBean(EasyConfigUtil.class);
        Properties p = util.getConfig(12l, "test1");
        System.out.println(p);
    }
}
