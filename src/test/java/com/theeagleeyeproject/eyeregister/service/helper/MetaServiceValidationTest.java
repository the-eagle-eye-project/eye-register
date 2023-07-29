package com.theeagleeyeproject.eyeregister.service.helper;

import com.theeagleeyeproject.eyeregister.entity.EyeRegistryEntity;
import com.theeagleeyeproject.eyeregister.exception.GlobalApplicationException;
import com.theeagleeyeproject.eyeregister.repository.EyeRegistryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MetaServiceValidationTest {

    @Mock
    private EyeRegistryRepository eyeRegistryRepository;

    private MetaServiceValidation metaServiceValidation;

    @BeforeEach
    void init() {
        metaServiceValidation = new MetaServiceValidation(eyeRegistryRepository);
    }

    @Test
    void validateRelatedIntegrations_ThrowsException() {
        when(eyeRegistryRepository.findByIntegrationId(anyString())).thenReturn(null);
        assertThrows(GlobalApplicationException.class, () -> metaServiceValidation.validateRelatedIntegrations(List.of("4235")));
    }

    @Test
    void validateRelatedIntegrations_DoesntThrowsException() {
        when(eyeRegistryRepository.findByIntegrationId(anyString())).thenReturn(new EyeRegistryEntity());
        assertDoesNotThrow(() -> metaServiceValidation.validateRelatedIntegrations(List.of("4230985")));
    }
}