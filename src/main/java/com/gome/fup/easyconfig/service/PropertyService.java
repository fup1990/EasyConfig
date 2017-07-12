package com.gome.fup.easyconfig.service;

import com.gome.fup.easyconfig.model.Property;

import java.util.List;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
public interface PropertyService {

    Property getPropertyById(long id);

    List<Property> getPropertyByProjectIdAndGroupName(long projectId, String groupName);

    void save(Property property);

    void edit(Property property);
}
