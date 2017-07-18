package com.gome.fup.easyconfig.common;

import com.gome.fup.easyconfig.model.Config;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * 
 *
 * @author fupeng-ds
 */
@SuppressWarnings("serial")
public class Response implements Serializable{
	
	private Long projectId;

	private String groupName;

	List<Config> configs;

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

	public List<Config> getConfigs() {
		return configs;
	}

	public void setConfigs(List<Config> configs) {
		this.configs = configs;
	}
}
