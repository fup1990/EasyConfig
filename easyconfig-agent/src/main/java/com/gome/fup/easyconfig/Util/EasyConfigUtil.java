package com.gome.fup.easyconfig.util;

import com.gome.fup.easyconfig.client.ConfigClient;

import java.util.Properties;

/**
 * Created by fupeng-ds on 2017/7/21.
 */
public class EasyConfigUtil extends ConfigClient{

    public Properties getConfig(String projectId, String groupName) {
        return getConfig(projectId, groupName, null);
    }

    public Properties getConfig(String projectId, String groupName, String key) {
        return loadConfig(projectId, groupName, key);
    }
}
