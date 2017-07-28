package com.gome.fup.easyconfig.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
public class Config implements Serializable{

    private Long id;

    private String projectId;

    private String groupName;

    private List<Metadata> metadataList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
