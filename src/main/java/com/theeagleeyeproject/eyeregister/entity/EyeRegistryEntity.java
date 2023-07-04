package com.theeagleeyeproject.eyeregister.entity;

import com.theeagleeyeproject.eyeregister.model.metadata.ApplicationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Document(indexName = "meta-eye-idx")
public class EyeRegistryEntity {

    @Id
    @Field(name = "integration_id", type = FieldType.Keyword)
    private String integrationId;

    @Field(name = "application_name", type = FieldType.Text)
    private String applicationName;

    @Enumerated(EnumType.STRING)
    @Field(name = "application_type", type = FieldType.Keyword)
    private ApplicationType applicationType;

    @Field(name = "application_step", type = FieldType.Keyword)
    private String applicationStep;

    @Field(name = "related_integration_ids", type = FieldType.Keyword)
    private List<String> relatedIntegrationIds;

    @Field(name = "logs_ttl", type = FieldType.Long)
    private long logsTtl;

    @Field(type = FieldType.Keyword, name = "is_active")
    private boolean isActive;

    @CreatedDate
    @Field(name = "record_created_timestamp", type = FieldType.Date)
    private LocalDateTime recordCreatedTimestamp;

    @LastModifiedDate
    @Field(name = "record_updated_timestamp", type = FieldType.Date)
    private LocalDateTime recordUpdatedTimestamp;

    @CreatedBy
    @Field(name = "record_created_by", type = FieldType.Text)
    private String recordCreatedBy;

    @LastModifiedBy
    @Field(name = "record_updated_by", type = FieldType.Text)
    private String recordUpdatedBy;
}
