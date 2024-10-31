package com.posco.standardmanagement.s20a01.domain;

import com.posco.standardmanagement.s20a01.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "maintenanceRecords",
    path = "maintenanceRecords"
)
public interface MaintenanceRecordRepository
    extends JpaRepository<MaintenanceRecord, Long> {}
