package com.gome.fup.propertyhelper;

import com.gome.fup.propertyhelper.model.Property;
import com.gome.fup.propertyhelper.service.PropertyService;
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
public class PropertyControllerTest {

    @Autowired
    private PropertyService propertyService;

    @Test
    public void test() {
        Property property = propertyService.getPropertyById(1l);
        System.out.println(property);
    }
}
