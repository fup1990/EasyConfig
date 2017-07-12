package com.gome.fup.easyconfig.mapper;

import com.gome.fup.easyconfig.model.Property;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
public interface PropertyMapper {

    Property getPropertyById(long id);

    List<Property> getPropertyByProjectIdAndGroupName(@Param("projectId")long projectId, @Param("groupName")String groupName);

    void inser(Property property);

    void edit(Property property);
}
