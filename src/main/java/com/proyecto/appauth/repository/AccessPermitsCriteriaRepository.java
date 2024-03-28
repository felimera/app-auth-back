package com.proyecto.appauth.repository;

import com.proyecto.appauth.model.AccessPermits;

import java.util.List;

public interface AccessPermitsCriteriaRepository {
    List<AccessPermits> getAccessPermitsByRoleType(String acronym);
}
