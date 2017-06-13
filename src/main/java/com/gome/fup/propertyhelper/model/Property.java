package com.gome.fup.propertyhelper.model;

import java.io.Serializable;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
public class Property implements Serializable{

    private long id;

    private long projectId;

    private String groupName;

    private String data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
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
