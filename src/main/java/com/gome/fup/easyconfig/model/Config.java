package com.gome.fup.easyconfig.model;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
public class Config implements Serializable{

    private Long id;

    private Long projectId;

    private String groupName;

    private List<Metadata> metadataList;

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

    public List<Metadata> getMetadataList() {
        return metadataList;
    }

    public void setMetadataList(List<Metadata> metadataList) {
        this.metadataList = metadataList;
    }
}
