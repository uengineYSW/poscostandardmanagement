package com.posco.standardmanagement.s20a01.service;

import com.posco.standardmanagement.s20a01.domain.VehicleChange;
import com.posco.standardmanagement.s20a01.domain.VehicleChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/vehicleChanges")
@Service
@Transactional
public class VehicleChangeRepositoryService {

    private final VehicleChangeRepository vehicleChangeRepository;

    @Autowired
    public VehicleChangeRepositoryService(
        VehicleChangeRepository vehicleChangeRepository
    ) {
        this.vehicleChangeRepository = vehicleChangeRepository;
    }
}
