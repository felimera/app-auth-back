package com.proyecto.appauth.service.implementation;

import com.proyecto.appauth.controller.dto.AccessPermitsDto;
import com.proyecto.appauth.controller.dto.RouterLinkDto;
import com.proyecto.appauth.controller.mapper.RouterLinkMapper;
import com.proyecto.appauth.model.AccessPermits;
import com.proyecto.appauth.model.RoleType;
import com.proyecto.appauth.service.AccessPermitsStageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessPermitsStageServiceImpl implements AccessPermitsStageService {
    @Override
    public AccessPermitsDto getAccessPermitsDto(List<AccessPermits> accessPermitsList) {
        AccessPermitsDto permitsDto = new AccessPermitsDto();

        if (accessPermitsList.isEmpty()) return permitsDto;

        List<RouterLinkDto> routerLinkDtos = accessPermitsList
                .stream()
                .map(accessPermits -> RouterLinkMapper.INSTANCE.toDto(accessPermits.getRouterLink()))
                .toList();

        RoleType rol = accessPermitsList.get(0).getRoleType();
        permitsDto.setIdRol(rol.getId());
        permitsDto.setNombreRol(rol.getName());
        permitsDto.setAcronimoRol(rol.getAcronym());
        permitsDto.setDescripcionRol(rol.getDescription());
        permitsDto.setLinkList(routerLinkDtos);

        return permitsDto;
    }
}
