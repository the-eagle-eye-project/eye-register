package com.theeagleeyeproject.eyeregister.model;

import com.theeagleeyeproject.eyeregister.model.metadata.ApplicationType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EyeMetaServiceResponse {

    private String integrationId;

    private String applicationName;
 
    private ApplicationType applicationType;

    private String applicationStep;

    private List<String> relatedIntegrationIds;

    private long logsTtl;

    private boolean isActive;

    private LocalDateTime recordCreatedTimestamp;

    private LocalDateTime recordUpdatedTimestamp;

    private String recordCreatedBy;

    private String recordUpdatedBy;

}
