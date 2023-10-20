package com.theeagleeyeproject.eyeregister.service.mapper;

import com.theeagleeyeproject.eyeregister.entity.EyeRegistryEntity;
import com.theeagleeyeproject.eyeregister.entity.RelatedIntegrationIdEntity;
import com.theeagleeyeproject.eyeregister.model.EyeMetaRegisterServiceRequest;
import com.theeagleeyeproject.eyeregister.model.EyeMetaRegisterServiceResponse;
import com.theeagleeyeproject.eyeregister.model.EyeMetaServiceResponse;
import com.theeagleeyeproject.eyeregister.model.RelatedIntegrationId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Mapper
public interface MetadataMapper {

    @Mapping(target = "integrationId", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(source = "relatedIntegrationIds", target = "relatedIntegrationIdsEntity", qualifiedByName = "toRelatedIntegrationIdsEntity")
    EyeRegistryEntity metaServiceRequestToEyeRegistryEntity(EyeMetaRegisterServiceRequest eyeMetaRegisterServiceRequest);

    @Mapping(target = "integrationIdMessage", expression = "java(\"Please save the integration id, since it has to be used" +
            "to send logs to the database.\")")
    EyeMetaRegisterServiceResponse eyeRegistryEntityToEyeMetaServiceResponse(EyeRegistryEntity eyeRegistryEntity);

    EyeMetaServiceResponse eyeMetaEntityToEyeMetaServiceResponse(EyeRegistryEntity eyeRegistryEntity);

    @Named("toRelatedIntegrationIdsEntity")
    default List<RelatedIntegrationIdEntity> toRelatedIntegrationIdsEntity(List<RelatedIntegrationId> relatedIntegrationIds) {
        return relatedIntegrationIds != null ? relatedIntegrationIds.stream()
                .filter(Objects::nonNull)
                .map(relatedIntegrationId -> new RelatedIntegrationIdEntity(relatedIntegrationId.getRelatedIntegrationId(), relatedIntegrationId.getIntegrationPosition()))
                .collect(Collectors.toList()) : null;
    }
}
