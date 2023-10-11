package com.theeagleeyeproject.eyeregister.service;

import com.theeagleeyeproject.eyeregister.entity.EyeRegistryEntity;
import com.theeagleeyeproject.eyeregister.model.EyeMetaRegisterServiceRequest;
import com.theeagleeyeproject.eyeregister.model.EyeMetaRegisterServiceResponse;
import com.theeagleeyeproject.eyeregister.model.EyeMetaServiceResponse;
import com.theeagleeyeproject.eyeregister.repository.EyeRegisterRepository;
import com.theeagleeyeproject.eyeregister.service.helper.MetaServiceValidation;
import com.theeagleeyeproject.eyeregister.service.mapper.MetadataMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetaRegisterService {

    private final EyeRegisterRepository eyeRegistryRepository;

    private final MetaServiceValidation metaServiceValidation;

    private final MetadataMapper metadataMapper = Mappers.getMapper(MetadataMapper.class);

    public EyeMetaRegisterServiceResponse createMeta(EyeMetaRegisterServiceRequest request) {
        if (request.getRelatedIntegrationIds() != null)
            metaServiceValidation.validateRelatedIntegrations(request.getRelatedIntegrationIds());
        EyeRegistryEntity registryEntity = metadataMapper.metaServiceRequestToEyeRegistryEntity(request);
        eyeRegistryRepository.save(registryEntity);
        return metadataMapper.eyeRegistryEntityToEyeMetaServiceResponse(registryEntity);
    }

    public EyeMetaServiceResponse getMeta(String integrationId) {
        EyeRegistryEntity eyeRegistryEntity = eyeRegistryRepository.findByIntegrationId(integrationId);
        return metadataMapper.eyeMetaEntityToEyeMetaServiceResponse(eyeRegistryEntity);
    }
}
