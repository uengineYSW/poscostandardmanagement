package com.posco.standardmanagement.s20a01.service;

import com.posco.standardmanagement.s20a01.domain.InsuranceInfo;
import com.posco.standardmanagement.s20a01.domain.InsuranceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/insuranceInfos")
@Service
@Transactional
public class InsuranceInfoRepositoryService {

    private final InsuranceInfoRepository insuranceInfoRepository;

    @Autowired
    public InsuranceInfoRepositoryService(
        InsuranceInfoRepository insuranceInfoRepository
    ) {
        this.insuranceInfoRepository = insuranceInfoRepository;
    }
}
