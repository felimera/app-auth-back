package com.proyecto.appauth.service;

import com.proyecto.appauth.controller.dto.AccessPermitsDto;
import com.proyecto.appauth.model.AccessPermits;

import java.util.List;

public interface AccessPermitsStageService {
    AccessPermitsDto getAccessPermitsDto(List<AccessPermits> accessPermitsList);
}
