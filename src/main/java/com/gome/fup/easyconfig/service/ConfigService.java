package com.gome.fup.easyconfig.service;

import com.gome.fup.easyconfig.model.Config;

import java.util.List;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
public interface ConfigService {

    Config getPropertyById(long id);

    List<Config> getPropertyByProjectIdAndGroupName(long projectId, String groupName);

    void save(Config config);

    void edit(Config config);
}
