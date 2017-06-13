package com.gome.fup.propertyhelper.service;

import com.gome.fup.propertyhelper.mapper.PropertyMapper;
import com.gome.fup.propertyhelper.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
@Service
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    private PropertyMapper propertyMapper;

    @Override
    public Property getPropertyById(long id) {
        return propertyMapper.getPropertyById(id);
    }
}
