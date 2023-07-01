package com.theeagleeyeproject.eyeregister.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Document(indexName = "eye-registry-idx")
public class EyeRegistryEntity {

    @Id
    private String integrationId;

    private String applicationName;

    private String applicationStep;

    private List<String> relatedIntegrationIds;

    private long logsTtl;

    private boolean isActive;

    @CreatedDate
    private LocalDateTime recordCreatedTimestamp;

    @LastModifiedDate
    private LocalDateTime recordUpdatedTimestamp;

    @CreatedBy
    private String recordCreatedBy;

    @LastModifiedBy
    private String recordUpdatedBy;
}
