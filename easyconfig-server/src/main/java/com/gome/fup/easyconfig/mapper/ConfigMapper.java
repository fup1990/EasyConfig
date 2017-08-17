package com.gome.fup.easyconfig.mapper;

import com.gome.fup.easyconfig.common.Config;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fupeng-ds on 2017/6/13.
 */
public interface ConfigMapper {

    Config getPropertyById(long id);

    List<Config> getPropertyByProjectIdAndGroupName(@Param("projectId")String projectId, @Param("groupName")String groupName, @Param("key")String key);

    void insert(Config config);

    void edit(Config config);

    List<Config> queryConfigByParam(@Param("projectId") String projectId, @Param("groupName") String groupName);

    List<Config> search(@Param("projectId") String projectId, @Param("groupName") String groupName);

    void deleteById(@Param("id") Long id);
}
