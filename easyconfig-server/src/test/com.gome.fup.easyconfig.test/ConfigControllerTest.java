package com.gome.fup.easyconfig.test;

import com.gome.fup.easyconfig.common.Config;
import com.gome.fup.easyconfig.service.ConfigService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
public class ConfigControllerTest {

    @Autowired
    private ConfigService configService;

    @Test
    public void test() {
        Config config = configService.getPropertyById(1l);
        System.out.println(config);
    }
}
