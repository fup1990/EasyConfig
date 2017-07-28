package com.gome.fup.easyconfig.config;

import com.gome.fup.easyconfig.util.EasyConfigUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Map;
import java.util.Properties;

/**
 * Created by fupeng-ds on 2017/7/28.
 */
public class EasyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    public EasyConfigUtil configUtil;

    public String projectId;

    public String groupName;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        Properties config = configUtil.getConfig(projectId, groupName);
        for (Map.Entry<Object, Object> entry : config.entrySet()) {
            props.put(entry.getKey(), entry.getValue());
        }
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public EasyConfigUtil getConfigUtil() {
        return configUtil;
    }

    public void setConfigUtil(EasyConfigUtil configUtil) {
        this.configUtil = configUtil;
    }
}
