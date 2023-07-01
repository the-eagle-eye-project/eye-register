package com.theeagleeyeproject.eyeregister.service;

import com.theeagleeyeproject.eyeregister.model.ElasticMetaServiceResponse;
import com.theeagleeyeproject.eyeregister.model.MetaServiceRequest;
import com.theeagleeyeproject.eyeregister.model.MetaServiceResponse;
import com.theeagleeyeproject.eyeregister.service.helper.EyeRegistryEntityCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetaRegisterService {

    private final EyeRegistryEntityCreator eyeRegistryEntityCreator;

    public MetaServiceResponse createMeta(MetaServiceRequest request) {
        return null;
    }

    public ElasticMetaServiceResponse getMeta(String integrationId) {
        return null;
    }
}
