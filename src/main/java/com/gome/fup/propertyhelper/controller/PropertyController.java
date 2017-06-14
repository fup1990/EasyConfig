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
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping("/info")
    public ModelAndView getPropertyById(long id) {
        ModelAndView mav = new ModelAndView();
        Property property = propertyService.getPropertyById(id);
        mav.setViewName("property/info");
        mav.addObject("property",property);
        return mav;
    }

    @RequestMapping("/search")
    public ModelAndView getPropertyByProjectIdAndGroupName(long projectId, String groupName) {
        ModelAndView mav = new ModelAndView();
        List<Property> list = propertyService.getPropertyByProjectIdAndGroupName(projectId, groupName);
        mav.addObject("list", list);
        mav.setViewName("property/list");
        return mav;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(long id) {
        ModelAndView mav = new ModelAndView();
        Property property = propertyService.getPropertyById(id);
        mav.setViewName("property/edit");
        mav.addObject("property", property);
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView add() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("property/add");
        return mav;
    }

    @RequestMapping("/save")
    public ModelAndView save(Property property) {
        ModelAndView mav = new ModelAndView("redirect:/");
        if (null != property.getId()) {
            propertyService.edit(property);
        } else {
            propertyService.save(property);
        }
        return mav;
    }
}
