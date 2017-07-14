package com.gome.fup.easyconfig.common;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by fupeng-ds on 2017/7/14.
 */
public class Request implements Serializable{

    private Long id;

    private int status;

    private Long projectId;

    private String groupName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

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
