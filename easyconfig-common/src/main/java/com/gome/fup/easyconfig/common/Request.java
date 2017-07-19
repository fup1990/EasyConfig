package com.gome.fup.easyconfig.common;

import java.io.Serializable;

/**
 * Created by fupeng-ds on 2017/7/14.
 */
public class Request implements Serializable{

    private Long projectId;

    private String groupName;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
