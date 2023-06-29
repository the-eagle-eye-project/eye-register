package com.theeagleeyeproject.eyeregister.model.metadata;

/**
 * {@code ApplicationType} types of applications that will be onboarded into the metadata index.
 *
 * @author John Robert Martinez Ponce
 */
public enum ApplicationType {

    /**
     * System of records, application that will be providing data to others for consuming
     */
    SOR,

    /**
     * Consumer of data provided by other SORs
     */
    CONSUMER,

    /**
     * Intermediate application that will receive and pass forward
     */
    TRANSMITTER
}
