package com.gome.fup.easyconfig.Util;

import com.gome.fup.easyconfig.client.ConfigClient;
import com.gome.fup.easyconfig.common.Config;

import java.util.Properties;

/**
 * Created by fupeng-ds on 2017/7/21.
 */
public class EasyConfigUtil extends ConfigClient{

    public Properties getConfig(Long projectId, String groupName) {
        return getConfig(projectId, groupName, null);
    }

    public Properties getConfig(Long projectId, String groupName, String key) {
        return loadConfig(projectId, groupName, key);
    }
}
