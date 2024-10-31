package com.posco.othermanagement.s20a01.service;

import com.posco.othermanagement.s20a01.domain.CodeManagement;
import com.posco.othermanagement.s20a01.domain.CodeManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/codeManagements")
@Service
@Transactional
public class CodeManagementRepositoryService {

    private final CodeManagementRepository codeManagementRepository;

    @Autowired
    public CodeManagementRepositoryService(
        CodeManagementRepository codeManagementRepository
    ) {
        this.codeManagementRepository = codeManagementRepository;
    }
}
