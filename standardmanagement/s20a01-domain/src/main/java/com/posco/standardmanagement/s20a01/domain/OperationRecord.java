package com.posco.standardmanagement.s20a01.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OperationRecord_table")
@Data
public class OperationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;

    private Date operationDate;

    private Long operationSeq;

    private String driverId;

    private String passengerWorkDistinction;

    private String operationPurpose;

    private Long numberOfPassengers;

    private String operationPlace;

    private Long operationKm;

    private Date departureTime;

    private Date arrivalTime;

    private Long operationTimeMin;

    private Long waitingTimeMin;

    private String fuelSupplier;

    private Long fuelAmount;

    private Long fuelUnitPrice;

    private Long cardFuelAmount;

    private Long cardFuelSupplyAmount;

    private Long cardFuelTax;

    private Long cardTollFee;

    private Long cashFuelAmount;

    private Long cashFuelSupplyAmount;

    private Long cashFuelTax;

    private Long cashTollFee;

    private Long cashParkingFee;

    private String remarks;
}
