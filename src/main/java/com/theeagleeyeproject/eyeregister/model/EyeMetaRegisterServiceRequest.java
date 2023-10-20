package com.theeagleeyeproject.eyeregister.model;

import com.theeagleeyeproject.eyeregister.model.metadata.ApplicationType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * {@link EyeMetaRegisterServiceRequest} used to receive the consumer's request to add new metadata to the Eye Database. This will
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
public class EyeMetaRegisterServiceRequest {

    /**
     * {@link ApplicationType} type of the application that will be integrated.
     */
    @NotNull
    private ApplicationType applicationType;

    /**
     * Name of the application that will be either providing or consuming.
     */
    @NotNull
    private String applicationName;

    /**
     * Contains a description of the application been registered.
     */
    @NotNull
    private String applicationDescription;

    /**
     * Step of the application uploading the logs.
     */
    @NotNull
    private int applicationStep;

    /**
     * Determines what would be the life of the logs for this specific integration.
     * <pre>
     *     0(zero) -> is unlimited TTL
     *     1 -> one day of TTL
     * </pre>
     */
    @NotNull
    private long logsTtl;

    /**
     * List of consumers that should receive the transactions associated to this integration id.
     */
    private List<RelatedIntegrationId> relatedIntegrationIds;

    /**
     * Describes the request alerting level.
     */
    @NotNull
    private AlertLevel alertLevel;
}
