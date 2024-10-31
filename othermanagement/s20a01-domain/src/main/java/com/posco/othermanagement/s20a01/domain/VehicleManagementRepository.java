package com.posco.othermanagement.s20a01.domain;

import com.posco.othermanagement.s20a01.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "vehicleManagements",
    path = "vehicleManagements"
)
public interface VehicleManagementRepository
    extends JpaRepository<VehicleManagement, Long> {}
