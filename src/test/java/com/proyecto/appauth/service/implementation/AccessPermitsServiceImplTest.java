package com.proyecto.appauth.service.implementation;

import com.proyecto.appauth.model.AccessPermits;
import com.proyecto.appauth.model.builder.AccessPermitsBuilder;
import com.proyecto.appauth.repository.AccessPermitsRepository;
import com.proyecto.appauth.util.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AccessPermitsServiceImplTest {
    @Mock
    private AccessPermitsRepository accessPermitsRepository;
    @InjectMocks
    private AccessPermitsServiceImpl accessPermitsServiceImpl;

    @DisplayName("Test JUnit for the GetAccessPermitsByRoleType method.")
    @Test
    void whenTheQueryReturnsResults() {
        AccessPermits entity1 = AccessPermitsBuilder.builder().build().toAccessPermits();
        AccessPermits entity2 = AccessPermitsBuilder.builder().build().toAccessPermits();

        given(accessPermitsRepository.getAccessPermitsByRoleType(anyString())).willReturn(List.of(entity1, entity2));
        List<AccessPermits> accessPermitsList = accessPermitsServiceImpl.getAccessPermitsByRoleType(Constants.A);
        assertThat(accessPermitsList).isNotNull();
        assertTrue(accessPermitsList.size() >= 2);
    }
}