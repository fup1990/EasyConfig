package com.gome.fup.easyconfig.common;

import java.io.Serializable;

/**
 * Created by fupeng-ds on 2017/7/14.
 */
public class Request implements Serializable{

    private String projectId;

    private String groupName;

    private String key;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
