package com.gome.fup.easyconfig.service;

import com.gome.fup.easyconfig.mapper.ConfigMapper;
import com.gome.fup.easyconfig.model.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigMapper propertyMapper;

    @Override
    public Config getPropertyById(long id) {
        return propertyMapper.getPropertyById(id);
    }

    @Override
    public List<Config> getPropertyByProjectIdAndGroupName(long projectId, String groupName) {
        return propertyMapper.getPropertyByProjectIdAndGroupName(projectId, groupName);
    }

    @Override
    public void save(Config config) {
        propertyMapper.inser(config);
    }

    @Override
    public void edit(Config config) {
        propertyMapper.edit(config);
    }
}
