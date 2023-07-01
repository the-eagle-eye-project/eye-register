package com.theeagleeyeproject.eyeregister.repository;


import com.theeagleeyeproject.eyeregister.entity.EyeRegistryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EyeRegistryRepository extends ElasticsearchRepository<EyeRegistryEntity, String> {

    Page<EyeRegistryEntity> findByApplicationName(String applicationName, Pageable pageable);
}
