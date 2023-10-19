package com.theeagleeyeproject.eyeregister.service.helper;

import com.theeagleeyeproject.eyeregister.repository.EyeRegisterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MetaServiceValidationTest {

    @Mock
    private EyeRegisterRepository eyeRegistryRepository;

    private MetaServiceValidation metaServiceValidation;

    @BeforeEach
    void init() {
        metaServiceValidation = new MetaServiceValidation(eyeRegistryRepository);
    }

/*    @Test
    void validateRelatedIntegrations_ThrowsException() {
        when(eyeRegistryRepository.findByIntegrationId(anyString())).thenReturn(null);
        assertThrows(GlobalApplicationException.class, () -> metaServiceValidation.validateRelatedIntegrations(List.of("4235")));
    }

    @Test
    void validateRelatedIntegrations_DoesntThrowsException() {
        when(eyeRegistryRepository.findByIntegrationId(anyString())).thenReturn(new EyeRegistryEntity());
        assertDoesNotThrow(() -> metaServiceValidation.validateRelatedIntegrations(List.of("4230985")));
    }*/
}