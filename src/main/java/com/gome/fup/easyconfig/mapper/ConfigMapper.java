package com.gome.fup.easyconfig.mapper;

import com.gome.fup.easyconfig.model.Config;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
public interface ConfigMapper {

    Config getPropertyById(long id);

    List<Config> getPropertyByProjectIdAndGroupName(@Param("projectId")long projectId, @Param("groupName")String groupName);

    Config inser(Config config);

    void edit(Config config);
}
