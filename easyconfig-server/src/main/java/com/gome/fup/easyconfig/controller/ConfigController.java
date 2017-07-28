package com.gome.fup.easyconfig.controller;

import com.gome.fup.easyconfig.common.Config;
import com.gome.fup.easyconfig.service.ConfigService;
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
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @RequestMapping("/info")
    public ModelAndView getPropertyById(long id) {
        ModelAndView mav = new ModelAndView();
        Config config = configService.getPropertyById(id);
        mav.setViewName("property/info");
        mav.addObject("property", config);
        return mav;
    }

    @RequestMapping("/search")
    public ModelAndView getPropertyByProjectIdAndGroupName(String projectId, String groupName) {
        ModelAndView mav = new ModelAndView();
        List<Config> list = configService.getPropertyByProjectIdAndGroupName(projectId, groupName, null);
        mav.addObject("list", list);
        mav.setViewName("property/list");
        return mav;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(long id) {
        ModelAndView mav = new ModelAndView();
        Config config = configService.getPropertyById(id);
        mav.setViewName("property/edit");
        mav.addObject("property", config);
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView add() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("property/add");
        return mav;
    }

    @RequestMapping("/save")
    public ModelAndView save(Long id, String projectId, String groupName, String data) {
        ModelAndView mav = new ModelAndView("redirect:/");
        configService.save(buildConfig(id, projectId, groupName), data);
        return mav;
    }

    private Config buildConfig(Long id, String projectId, String groupName) {
        Config config = new Config();
        config.setId(id);
        config.setProjectId(projectId);
        config.setGroupName(groupName);
        return config;
    }

}
