package com.theeagleeyeproject.eyeregister.entity;

import com.theeagleeyeproject.eyeregister.model.metadata.ApplicationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Document(collection = "eye_registry")
public class EyeRegistryEntity {

    @Id
    @Field(name = "integration_id")
    private String integrationId;

    @Field(name = "application_name")
    private String applicationName;

    @Enumerated(EnumType.STRING)
    @Field(name = "application_type")
    private ApplicationType applicationType;

    @Field(name = "application_step")
    private String applicationStep;

    @Field(name = "related_integration_ids")
    private List<String> relatedIntegrationIds;

    @Field(name = "logs_ttl")
    private long logsTtl;

    @Field(name = "is_active")
    private boolean isActive;

    @CreatedDate
    @Field(name = "record_created_timestamp")
    private LocalDateTime recordCreatedTimestamp;

    @LastModifiedDate
    @Field(name = "record_updated_timestamp")
    private LocalDateTime recordUpdatedTimestamp;

    @CreatedBy
    @Field(name = "record_created_by")
    private String recordCreatedBy;

    @LastModifiedBy
    @Field(name = "record_updated_by")
    private String recordUpdatedBy;
}
