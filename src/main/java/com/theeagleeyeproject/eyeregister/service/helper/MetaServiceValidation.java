package com.theeagleeyeproject.eyeregister.service.helper;

import com.theeagleeyeproject.eyeregister.exception.ExceptionCategory;
import com.theeagleeyeproject.eyeregister.exception.GlobalApplicationException;
import com.theeagleeyeproject.eyeregister.model.EyeMetaRegisterServiceRequest;
import com.theeagleeyeproject.eyeregister.repository.EyeRegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MetaServiceValidation {

    private final EyeRegisterRepository eyeRegistryRepository;

    public void validate(EyeMetaRegisterServiceRequest request) {
        if (request.getRelatedIntegrationIds() != null)
            validateRelatedIntegrations(request.getRelatedIntegrationIds());

        if (eyeRegistryRepository.findByApplicationName(request.getApplicationName()) != null)
            throw new GlobalApplicationException(ExceptionCategory.VALIDATION_ERROR, "Application Name already exists in our records.");


    }

    private void validateRelatedIntegrations(@NotNull List<String> relatedIntegration) {
        relatedIntegration
                .forEach(integration -> {
                    if (eyeRegistryRepository.findByIntegrationId(integration) == null) {
                        throw new GlobalApplicationException(ExceptionCategory.DATA_NOT_FOUND, "The ID passed as related integration is not valid or " +
                                "is not related to an existing integration registered.");
                    }
                });
    }


}
