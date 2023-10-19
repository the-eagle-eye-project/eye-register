package com.theeagleeyeproject.eyeregister.repository;

import com.theeagleeyeproject.eyeregister.entity.EyeRegistryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EyeRegisterRepository extends MongoRepository<EyeRegistryEntity, String> {

    EyeRegistryEntity findByIntegrationId(String integrationId);
    
    EyeRegistryEntity findByApplicationName(String applicationName);
}
