package com.proyecto.appauth.service.implementation;

import com.proyecto.appauth.controller.dto.AccessPermitsDto;
import com.proyecto.appauth.model.AccessPermits;
import com.proyecto.appauth.model.RoleType;
import com.proyecto.appauth.model.RouterLink;
import com.proyecto.appauth.model.builder.AccessPermitsBuilder;
import com.proyecto.appauth.model.builder.RoleTypeBuilder;
import com.proyecto.appauth.model.builder.RouterLinkBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
class AccessPermitsStageServiceImplTest {
    @InjectMocks
    private AccessPermitsStageServiceImpl accessPermitsStageServiceImpl;

    @DisplayName("Test JUnit for the GetAccessPermitsDto method.")
    @Test
    void whenTheDataIsTransferredSuccessfully() {
        RouterLink link = RouterLinkBuilder.builder().build().toRouterLink();
        RoleType type = RoleTypeBuilder.builder().build().toRoleType();
        AccessPermits entity = AccessPermitsBuilder
                .builder()
                .build()
                .toEditRouterAndRole(link, type);

        List<AccessPermits> accessPermitsList = Arrays.asList(entity, entity);

        AccessPermitsDto permitsDto = accessPermitsStageServiceImpl.getAccessPermitsDto(accessPermitsList);
        assertThat(permitsDto).isNotNull();
        assertThat(permitsDto.getIdRol()).isNotNull();
        assertThat(permitsDto.getAcronimoRol()).isNotNull();
        assertFalse(permitsDto.getLinkList().isEmpty());
    }
}