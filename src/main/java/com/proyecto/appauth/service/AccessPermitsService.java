package com.proyecto.appauth.service;

import com.proyecto.appauth.model.AccessPermits;

import java.util.List;

public interface AccessPermitsService {
    List<AccessPermits> getAccessPermitsByRoleType(String acronym);
}
