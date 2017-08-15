package com.gome.fup.easyconfig.controller;

import com.gome.fup.easyconfig.common.Config;
import com.gome.fup.easyconfig.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 配置管理Controller
 * Created by fupeng-ds on 2017/6/13.
 */
@RestController
public class ConfigController extends AbstractController{

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
    public String getPropertyByProjectIdAndGroupName(String projectId, String groupName) {
        List<Config> list = configService.search(projectId, groupName);
        return toJson(list);
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
