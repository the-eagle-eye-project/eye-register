package com.theeagleeyeproject.eyeregister.service.mapper;

import com.theeagleeyeproject.eyeregister.entity.EyeRegistryEntity;
import com.theeagleeyeproject.eyeregister.model.EyeMetaServiceRequest;
import com.theeagleeyeproject.eyeregister.model.EyeMetaServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MetadataMapper {

    @Mapping(target = "integrationId", expression = "java(java.util.UUID.randomUUID().toString())")
    EyeRegistryEntity metaServiceRequestToEyeRegistryEntity(EyeMetaServiceRequest eyeMetaServiceRequest);

    @Mapping(target = "integrationIdMessage", expression = "java(\"Please save the integration id, since it has to be used" +
            "to send logs to the database.\")")
    EyeMetaServiceResponse eyeRegistryEntityToEyeMetaServiceResponse(EyeRegistryEntity eyeRegistryEntity);
}
