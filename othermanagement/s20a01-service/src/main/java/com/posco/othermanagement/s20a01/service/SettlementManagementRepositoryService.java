package com.posco.othermanagement.s20a01.service;

import com.posco.othermanagement.s20a01.domain.SettlementManagement;
import com.posco.othermanagement.s20a01.domain.SettlementManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/settlementManagements")
@Service
@Transactional
public class SettlementManagementRepositoryService {

    private final SettlementManagementRepository settlementManagementRepository;

    @Autowired
    public SettlementManagementRepositoryService(
        SettlementManagementRepository settlementManagementRepository
    ) {
        this.settlementManagementRepository = settlementManagementRepository;
    }
}
