package com.proyecto.appauth.controller;

import com.proyecto.appauth.controller.dto.AccessPermitsDto;
import com.proyecto.appauth.model.AccessPermits;
import com.proyecto.appauth.service.AccessPermitsService;
import com.proyecto.appauth.service.AccessPermitsStageService;
import com.proyecto.appauth.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/guest")
@CrossOrigin(origins = "http://localhost:4200")
public class AccessGuestController {

    private AccessPermitsService accessPermitsService;
    private AccessPermitsStageService accessPermitsStageService;

    @Autowired
    public AccessGuestController(AccessPermitsService accessPermitsService, AccessPermitsStageService accessPermitsStageService) {
        this.accessPermitsService = accessPermitsService;
        this.accessPermitsStageService = accessPermitsStageService;
    }

    @GetMapping
    public ResponseEntity<AccessPermitsDto> getAllByAcronymGues() {

        List<AccessPermits> accessPermitsList = accessPermitsService.getAccessPermitsByRoleType(Constants.I);
        AccessPermitsDto permitsDto = accessPermitsStageService.getAccessPermitsDto(accessPermitsList);

        return ResponseEntity.ok(permitsDto);
    }
}
