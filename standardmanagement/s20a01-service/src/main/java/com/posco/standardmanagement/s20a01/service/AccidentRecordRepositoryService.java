package com.posco.standardmanagement.s20a01.service;

import com.posco.standardmanagement.s20a01.domain.AccidentRecord;
import com.posco.standardmanagement.s20a01.domain.AccidentRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/accidentRecords")
@Service
@Transactional
public class AccidentRecordRepositoryService {

    private final AccidentRecordRepository accidentRecordRepository;

    @Autowired
    public AccidentRecordRepositoryService(
        AccidentRecordRepository accidentRecordRepository
    ) {
        this.accidentRecordRepository = accidentRecordRepository;
    }
}
