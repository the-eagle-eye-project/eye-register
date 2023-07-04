package com.theeagleeyeproject.eyeregister.service.mapper;

import com.theeagleeyeproject.eyeregister.entity.EyeRegistryEntity;
import com.theeagleeyeproject.eyeregister.model.MetaServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MetadataMapper {

    @Mapping(target = "integrationId", expression = "java(java.util.UUID.randomUUID().toString())")
    EyeRegistryEntity metaServiceRequestToEyeRegistryEntity(MetaServiceRequest metaServiceRequest);
}
