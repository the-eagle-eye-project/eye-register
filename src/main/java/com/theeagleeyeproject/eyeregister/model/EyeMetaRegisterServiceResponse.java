package com.theeagleeyeproject.eyeregister.model;

import lombok.Data;

/**
 * {@code MetadataServiceResponse} used to return the integration id to the consumer when a metadata registration is
 * completed.
 *
 * @author John Robert Martinez Ponce
 */
@Data
public class EyeMetaRegisterServiceResponse {

    /**
     * Integration ID used for the consumer to access and send logs to the Eagle Eye Platform.
     */
    private String integrationId;

    /**
     * Registration message, to remind the consumer to save the integration id.
     */
    private String integrationIdMessage;
}
