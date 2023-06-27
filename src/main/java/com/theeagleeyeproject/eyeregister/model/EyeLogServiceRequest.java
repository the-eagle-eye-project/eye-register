package com.theeagleeyeproject.eyeregister.model;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class EyeLogServiceRequest {

    private String transactionId;
    private String applicationName;
    private String applicationStep;
    private LocalDateTime eventTimestamp;
    private String requestBody;
    private String requestUrl;
    private String sourceHost;
    private String transactionStatus; //TODO: should this be a ENUM????
    // TODO: Should I include a custom object, in case a custom use case can be added to the logs?
}
