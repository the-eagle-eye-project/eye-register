package com.theeagleeyeproject.eyeregister.service.mapper;

import com.theeagleeyeproject.eyeregister.entity.EyeRegistryEntity;
import com.theeagleeyeproject.eyeregister.model.MetaServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper
public interface MetadataMapper {

    @Mapping(target = "integrationId", qualifiedByName = "setIntegrationId")
    @Mapping(target = "isActive", qualifiedByName = "setActiveStatus")
    EyeRegistryEntity metaServiceRequestToEyeRegistryEntity(MetaServiceRequest metaServiceRequest);

    @Named(value = "setIntegrationId")
    default String setIntegrationId() {
        return UUID.randomUUID().toString();
    }

    @Named(value = "setActiveStatus")
    default boolean setActiveStatus() {
        return false;
    }
}
