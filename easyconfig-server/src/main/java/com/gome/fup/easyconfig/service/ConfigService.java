package com.gome.fup.easyconfig.service;

import com.gome.fup.easyconfig.common.Config;

import java.util.List;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
public interface ConfigService {

    Config getPropertyById(long id);

    List<Config> getPropertyByProjectIdAndGroupName(long projectId, String groupName, String key);

    void save(Config config, String data);

    void edit(Config config);
}
