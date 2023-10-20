package com.theeagleeyeproject.eyeregister.entity;

import com.theeagleeyeproject.eyeregister.model.IntegrationPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@AllArgsConstructor
public class RelatedIntegrationIdEntity {

    @Field(name = "related_integration_id")
    private String relatedIntegrationId;

    @Field(name = "integration_position")
    private IntegrationPosition integrationPosition;
}
