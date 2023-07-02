package com.theeagleeyeproject.eyeregister.model;

import com.theeagleeyeproject.eyeregister.model.metadata.ApplicationType;
import lombok.Data;

import java.util.List;

/**
 * {@link MetaServiceRequest} used to receive the consumer's request to add new metadata to the Eye Database. This will
 * enable a new application to log data into the Elastic index.
 * <p>
 * <br>
 * <strong>IMPORTANT:</strong> If an application sends data to other applications based on the data that it's been process, as of the
 * first version of this product, each datapoint that goes into different apps, should be registered as a different
 * integration, so that tracking of those transactions are accurate.
 * <p>
 *
 * @author John Robert Martinez Ponce
 */
@Data
public class MetaServiceRequest {

    /**
     * {@link ApplicationType} type of the application that will be integrated.
     */
    private ApplicationType applicationType;

    /**
     * Name of the application that will be either providing or consuming.
     */
    private String applicationName;

    /**
     * Step of the application uploading the logs.
     */
    private String applicationStep;

    /**
     * Determines what would be the life of the logs for this specific integration.
     */
    private long logsTtl;

    /**
     * List of consumers that should receive the transactions associated to this integration id.
     */
    private List<String> relatedIntegrationIds;
}
