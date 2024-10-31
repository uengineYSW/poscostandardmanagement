package com.posco.standardmanagement.s20a01.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "VehicleInfo_table")
@Data
public class VehicleInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;

    private String vehicleNumber;

    private String classification;

    private String manufacturerCode;

    private String vehicleTypeCode;

    private String vehicleModelCode;

    private String usageCode;

    private String fuelType;

    private String vehicleAffiliationCode;

    private String assetCode;

    private String operatingDepartment;

    private Long acquisitionAmount;

    private String responsibleDriverId;

    private String mainUser;

    private Date vehicleRegistrationDate;

    private Date vehicleSaleDate;

    private String chassisNumber;

    private String vehicleFormat;

    private String vehicleYear;

    private String output;

    private Long length;

    private Long width;

    private Long height;

    private Long weight;

    private Long loadCapacity;

    private Long displacement;

    private Long seatingCapacity;

    private Long standardFuelEfficiency;

    private Long fuelTankCapacity;

    private Long departureKm;

    private Long accumulatedKm;

    private Long totalAccumulatedKm;

    private Date regularInspectionDate;

    private String remarks;

    @Embedded
    private VehicleSpec vehicleSpec;

    @Embedded
    private VehicleOwnership vehicleOwnership;

    private String unavailabilityReason;

    private Date unavailabilityDate;

    public void markVehicleUnavailable(
        String unavailabilityReason,
        Date unavailabilityDate
    ) {
        // 비즈니스 로직 구현
    }
}
