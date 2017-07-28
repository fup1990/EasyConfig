package com.gome.fup.easyconfig.mapper;

import com.gome.fup.easyconfig.common.Metadata;

/**
 * Created by fupeng-ds on 2017/7/14.
 */
public interface MetadataMapper {

    void insert(Metadata metadata);

    void deleteByConfigId(Long configId);
}
