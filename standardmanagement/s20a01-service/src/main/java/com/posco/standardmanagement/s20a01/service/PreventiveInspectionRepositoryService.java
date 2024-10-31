package com.posco.standardmanagement.s20a01.service;

import com.posco.standardmanagement.s20a01.domain.PreventiveInspection;
import com.posco.standardmanagement.s20a01.domain.PreventiveInspectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/preventiveInspections")
@Service
@Transactional
public class PreventiveInspectionRepositoryService {

    private final PreventiveInspectionRepository preventiveInspectionRepository;

    @Autowired
    public PreventiveInspectionRepositoryService(
        PreventiveInspectionRepository preventiveInspectionRepository
    ) {
        this.preventiveInspectionRepository = preventiveInspectionRepository;
    }
}
