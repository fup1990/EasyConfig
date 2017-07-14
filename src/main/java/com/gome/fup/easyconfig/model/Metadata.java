package com.gome.fup.easyconfig.model;

import java.io.Serializable;

/**
 * Created by fupeng-ds on 2017/7/12.
 */
public class Metadata implements Serializable{

    private Long id;

    private Long configId;

    private String key;

    private String value;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }
}
