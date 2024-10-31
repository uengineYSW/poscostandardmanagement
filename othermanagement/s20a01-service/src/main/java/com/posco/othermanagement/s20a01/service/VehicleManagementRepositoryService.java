package com.posco.othermanagement.s20a01.service;

import com.posco.othermanagement.s20a01.domain.VehicleManagement;
import com.posco.othermanagement.s20a01.domain.VehicleManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/vehicleManagements")
@Service
@Transactional
public class VehicleManagementRepositoryService {

    private final VehicleManagementRepository vehicleManagementRepository;

    @Autowired
    public VehicleManagementRepositoryService(
        VehicleManagementRepository vehicleManagementRepository
    ) {
        this.vehicleManagementRepository = vehicleManagementRepository;
    }
}
