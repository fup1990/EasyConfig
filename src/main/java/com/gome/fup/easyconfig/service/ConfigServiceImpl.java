package com.gome.fup.easyconfig.service;

import com.gome.fup.easyconfig.mapper.ConfigMapper;
import com.gome.fup.easyconfig.mapper.MetadataMapper;
import com.gome.fup.easyconfig.model.Config;
import com.gome.fup.easyconfig.model.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<Config> getPropertyByProjectIdAndGroupName(long projectId, String groupName) {
        return propertyMapper.getPropertyByProjectIdAndGroupName(projectId, groupName);
    }

    @Override
    @Transactional
    public void save(Config config, String data) {
        Config model = propertyMapper.inser(config);
        saveMetadata(model.getId(), data);
    }

    private void saveMetadata(Long configId, String data) {
        String separator = System.getProperty("line.separator", "\n");
        String[] entrySet = data.split(separator);
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
