package com.posco.standardmanagement.s20a01.service;

import com.posco.standardmanagement.s20a01.domain.MaintenanceRecord;
import com.posco.standardmanagement.s20a01.domain.MaintenanceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/maintenanceRecords")
@Service
@Transactional
public class MaintenanceRecordRepositoryService {

    private final MaintenanceRecordRepository maintenanceRecordRepository;

    @Autowired
    public MaintenanceRecordRepositoryService(
        MaintenanceRecordRepository maintenanceRecordRepository
    ) {
        this.maintenanceRecordRepository = maintenanceRecordRepository;
    }
}
