package com.posco.standardmanagement.s20a01.service;

import com.posco.standardmanagement.s20a01.domain.OperationRecord;
import com.posco.standardmanagement.s20a01.domain.OperationRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/operationRecords")
@Service
@Transactional
public class OperationRecordRepositoryService {

    private final OperationRecordRepository operationRecordRepository;

    @Autowired
    public OperationRecordRepositoryService(
        OperationRecordRepository operationRecordRepository
    ) {
        this.operationRecordRepository = operationRecordRepository;
    }
}
