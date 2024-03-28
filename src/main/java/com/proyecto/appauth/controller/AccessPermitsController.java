package com.proyecto.appauth.controller;

import com.proyecto.appauth.controller.dto.AccessPermitsDto;
import com.proyecto.appauth.model.AccessPermits;
import com.proyecto.appauth.service.AccessPermitsService;
import com.proyecto.appauth.service.AccessPermitsStageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/access")
@CrossOrigin(origins = "http://localhost:4200")
public class AccessPermitsController {

    private AccessPermitsService accessPermitsService;
    private AccessPermitsStageService accessPermitsStageService;

    @Autowired
    public AccessPermitsController(AccessPermitsService accessPermitsService, AccessPermitsStageService accessPermitsStageService) {
        this.accessPermitsService = accessPermitsService;
        this.accessPermitsStageService = accessPermitsStageService;
    }

    @GetMapping
    public ResponseEntity<AccessPermitsDto> getAllByAcronym(@RequestParam(name = "acronym") String acronym) {

        List<AccessPermits> accessPermitsList = accessPermitsService.getAccessPermitsByRoleType(acronym);
        AccessPermitsDto permitsDto = accessPermitsStageService.getAccessPermitsDto(accessPermitsList);

        return ResponseEntity.ok(permitsDto);
    }
}
