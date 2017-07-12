package com.gome.fup.easyconfig.model;

import java.io.Serializable;
import java.util.Properties;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
public class Property implements Serializable{

    private Long id;

    private Long projectId;

    private String groupName;

    private String data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", groupName='" + groupName + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
