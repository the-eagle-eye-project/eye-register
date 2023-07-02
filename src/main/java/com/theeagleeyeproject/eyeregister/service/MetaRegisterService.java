package com.theeagleeyeproject.eyeregister.service;

import com.theeagleeyeproject.eyeregister.entity.EyeRegistryEntity;
import com.theeagleeyeproject.eyeregister.model.ElasticMetaServiceResponse;
import com.theeagleeyeproject.eyeregister.model.MetaServiceRequest;
import com.theeagleeyeproject.eyeregister.model.MetaServiceResponse;
import com.theeagleeyeproject.eyeregister.repository.EyeRegistryRepository;
import com.theeagleeyeproject.eyeregister.service.mapper.MetadataMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetaRegisterService {

    private final EyeRegistryRepository eyeRegistryRepository;

    private final MetadataMapper metadataMapper = Mappers.getMapper(MetadataMapper.class);

    public MetaServiceResponse createMeta(MetaServiceRequest request) {
        EyeRegistryEntity registryEntity = metadataMapper.metaServiceRequestToEyeRegistryEntity(request);
        eyeRegistryRepository.save(registryEntity);
        return null;
    }

    public ElasticMetaServiceResponse getMeta(String integrationId) {
        return null;
    }
}
