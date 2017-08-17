package com.gome.fup.easyconfig.service;

import com.github.pagehelper.PageInfo;
import com.gome.fup.easyconfig.common.Config;

import java.util.List;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
public interface ConfigService {

    Config getPropertyById(long id);

    List<Config> getPropertyByProjectIdAndGroupName(String projectId, String groupName, String key);

    void save(Config config, String data);

    void edit(Config config);

    List<Config> queryConfigByParam(String projectId, String groupName);

    List<Config> search(String projectId, String groupName);

    void delete(Long id);

    public PageInfo<Config> page(String projectId, String groupName);
}
