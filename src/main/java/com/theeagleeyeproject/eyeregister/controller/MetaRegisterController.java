package com.theeagleeyeproject.eyeregister.controller;

import com.theeagleeyeproject.eyeregister.model.ElasticMetaServiceResponse;
import com.theeagleeyeproject.eyeregister.model.MetaServiceRequest;
import com.theeagleeyeproject.eyeregister.model.MetaServiceResponse;
import com.theeagleeyeproject.eyeregister.service.MetaRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * {@link MetaRegisterController} controller class that takes care of the CRUD operations pertain to Metadata registration
 * and retrieve registered Metadata to the consumers.
 *
 * @author John Robert Martinez Ponce
 */
@RestController
@RequestMapping(name = "/eye/meta-register")
@RequiredArgsConstructor
public class MetaRegisterController {

    private final MetaRegisterService metaRegisterService;

    /**
     * POST Http method that registers new metadata to the Eye platform.
     *
     * @param headers request headers
     * @param request object created by the consumer to register a new integration to the platform
     * @return an object of type {@link MetaServiceResponse}
     */
    @PostMapping
    public ResponseEntity<MetaServiceResponse> createMeta(@RequestHeader HttpHeaders headers, @RequestBody MetaServiceRequest request) {
        MetaServiceResponse response = metaRegisterService.createMeta(request);
        return createResponseEntity(response);
    }

    /**
     * GET Http method that will return an existing metadata if exist in the database and is properly registered.
     *
     * @param headers       request headers
     * @param integrationId id to identify a specific registered integration
     * @return an object of type {@link ElasticMetaServiceResponse}
     */
    @GetMapping
    public ResponseEntity<ElasticMetaServiceResponse> getMeta(@RequestHeader HttpHeaders headers, @RequestParam(value = "integration_id") String integrationId) {
        ElasticMetaServiceResponse response = metaRegisterService.getMeta(integrationId);
        return createResponseEntity(response);
    }

    // Creates the response entity object for all the controller methods in this class.
    private <O> ResponseEntity<O> createResponseEntity(O response) {
        return response != null ? ResponseEntity.ok(response) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
