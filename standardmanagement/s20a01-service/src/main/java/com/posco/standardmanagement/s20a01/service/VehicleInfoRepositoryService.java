package com.posco.standardmanagement.s20a01.service;

import com.posco.standardmanagement.s20a01.domain.VehicleInfo;
import com.posco.standardmanagement.s20a01.domain.VehicleInfoRepository;
import com.posco.standardmanagement.s20a01.service.MarkVehicleUnavailableCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/vehicleInfos")
@Service
@Transactional
public class VehicleInfoRepositoryService {

    private final VehicleInfoRepository vehicleInfoRepository;

    @Autowired
    public VehicleInfoRepositoryService(
        VehicleInfoRepository vehicleInfoRepository
    ) {
        this.vehicleInfoRepository = vehicleInfoRepository;
    }

    @RequestMapping(
        value = "/{id}/markVehicleUnavailable",
        method = RequestMethod.POST
    )
    public VehicleInfo markVehicleUnavailable(
        @PathVariable("id") Long vehicleId,
        @RequestBody MarkVehicleUnavailableCommand markVehicleUnavailableCommand
    ) {
        VehicleInfo vehicleInfo = vehicleInfoRepository
            .findById(vehicleId)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "VehicleInfo not found"
                )
            );

        // Map command fields to method parameters
        vehicleInfo.markVehicleUnavailable(
            markVehicleUnavailableCommand.getUnavailabilityReason(),
            markVehicleUnavailableCommand.getUnavailabilityDate()
        );

        // 레포지토리에 저장
        return vehicleInfoRepository.save(vehicleInfo);
    }
}
