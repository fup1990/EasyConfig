package com.gome.fup.propertyhelper.service;

import com.gome.fup.propertyhelper.model.Property;

import java.util.List;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
public interface PropertyService {

    Property getPropertyById(long id);

    List<Property> getPropertyByProjectIdAndGroupName(long projectId, String groupName);
}
