package com.posco.othermanagement.s20a01.service;

import com.posco.othermanagement.s20a01.domain.EmployeeId;
import com.posco.othermanagement.s20a01.domain.EmployeeManagement;
import com.posco.othermanagement.s20a01.domain.EmployeeManagementRepository;
import com.posco.othermanagement.s20a01.service.ProcessEmployeeRetirementCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/employeeManagements")
@Service
@Transactional
public class EmployeeManagementRepositoryService {

    private final EmployeeManagementRepository employeeManagementRepository;

    @Autowired
    public EmployeeManagementRepositoryService(
        EmployeeManagementRepository employeeManagementRepository
    ) {
        this.employeeManagementRepository = employeeManagementRepository;
    }

    @RequestMapping(
        value = "/{id}/processEmployeeRetirement",
        method = RequestMethod.POST
    )
    public EmployeeManagement processEmployeeRetirement(
        @PathVariable("id") EmployeeId employeeId,
        @RequestBody ProcessEmployeeRetirementCommand processEmployeeRetirementCommand
    ) {
        EmployeeManagement employeeManagement = employeeManagementRepository
            .findById(employeeId)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "EmployeeManagement not found"
                )
            );

        // Map command fields to method parameters
        employeeManagement.processEmployeeRetirement(
            processEmployeeRetirementCommand.getRetirementDate(),
            processEmployeeRetirementCommand.getRetirementStatus()
        );

        // 레포지토리에 저장
        return employeeManagementRepository.save(employeeManagement);
    }
}
