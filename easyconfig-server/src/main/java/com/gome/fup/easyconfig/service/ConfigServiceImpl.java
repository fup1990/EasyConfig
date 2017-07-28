package com.gome.fup.easyconfig.service;

import com.gome.fup.easyconfig.common.Config;
import com.gome.fup.easyconfig.common.Metadata;
import com.gome.fup.easyconfig.mapper.ConfigMapper;
import com.gome.fup.easyconfig.mapper.MetadataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigMapper propertyMapper;
    @Autowired
    private MetadataMapper metadataMapper;

    @Override
    public Config getPropertyById(long id) {
        return propertyMapper.getPropertyById(id);
    }

    @Override
    public List<Config> getPropertyByProjectIdAndGroupName(String projectId, String groupName, String key) {
        return propertyMapper.getPropertyByProjectIdAndGroupName(projectId, groupName, key);
    }

    @Override
    @Transactional
    public void save(Config config, String data) {
        if (null == config.getId()) {
            propertyMapper.insert(config);
        } else {
            propertyMapper.edit(config);
        }
        metadataMapper.deleteByConfigId(config.getId());
        saveMetadata(config.getId(), data);
    }

    private void saveMetadata(Long configId, String data) {
        String separator = System.getProperty("line.separator", "\n");
        String[] entrySet = data.trim().split(separator);
        for (String entry : entrySet) {
            String[] split = entry.split("=");
            Metadata metadata = new Metadata();
            metadata.setKey(split[0].trim());
            metadata.setValue(split[1].trim());
            metadata.setConfigId(configId);
            metadataMapper.insert(metadata);
        }
    }

    @Override
    public void edit(Config config) {
        propertyMapper.edit(config);
    }
}
