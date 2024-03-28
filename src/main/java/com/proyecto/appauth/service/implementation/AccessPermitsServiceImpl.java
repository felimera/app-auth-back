package com.proyecto.appauth.service.implementation;

import com.proyecto.appauth.model.AccessPermits;
import com.proyecto.appauth.repository.AccessPermitsRepository;
import com.proyecto.appauth.service.AccessPermitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessPermitsServiceImpl implements AccessPermitsService {

    private AccessPermitsRepository accessPermitsRepository;

    @Autowired
    public AccessPermitsServiceImpl(AccessPermitsRepository accessPermitsRepository) {
        this.accessPermitsRepository = accessPermitsRepository;
    }

    @Override
    public List<AccessPermits> getAccessPermitsByRoleType(String acronym) {
        return accessPermitsRepository.getAccessPermitsByRoleType(acronym);
    }
}
