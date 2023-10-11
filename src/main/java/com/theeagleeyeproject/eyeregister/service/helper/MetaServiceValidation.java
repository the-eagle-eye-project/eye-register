package com.theeagleeyeproject.eyeregister.service.helper;

import com.theeagleeyeproject.eyeregister.exception.ExceptionCategory;
import com.theeagleeyeproject.eyeregister.exception.GlobalApplicationException;
import com.theeagleeyeproject.eyeregister.repository.EyeRegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MetaServiceValidation {

    private final EyeRegisterRepository eyeRegistryRepository;

    public void validateRelatedIntegrations(@NotNull List<String> relatedIntegration) {
        relatedIntegration
                .forEach(integration -> {
                    if (eyeRegistryRepository.findByIntegrationId(integration) == null) {
                        throw new GlobalApplicationException(ExceptionCategory.DATA_NOT_FOUND, "The ID passed as related integration is not valid or " +
                                "is not related to an existing integration registered.");
                    }
                });
    }
}
