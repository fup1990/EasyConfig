package com.gome.fup.propertyhelper.controller;

import com.gome.fup.propertyhelper.model.Property;
import com.gome.fup.propertyhelper.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 配置管理Controller
 * Created by fupeng-ds on 2017/6/13.
 */
@Controller
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping("/getProperty")
    public ModelAndView getPropertyById(long id) {
        ModelAndView mav = new ModelAndView();
        Property property = propertyService.getPropertyById(id);
        mav.setViewName("property");
        mav.addObject("property",property);
        return mav;
    }

    @RequestMapping("/getPropertyByParam")
    public ModelAndView getPropertyByProjectIdAndGroupName(long projectId, String groupName) {
        ModelAndView mav = new ModelAndView();
        List<Property> list = propertyService.getPropertyByProjectIdAndGroupName(projectId, groupName);
        mav.addObject("list",list);
        mav.setViewName("list");
        return mav;
    }
}
