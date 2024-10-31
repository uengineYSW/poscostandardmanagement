package com.posco.standardmanagement.s20a01.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "InsuranceInfo_table")
@Data
public class InsuranceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;

    private Date insuranceJoinDate;

    private Date validityFromDate;

    private Date validityToDate;

    private String insuranceCompany;

    private Double discountRate;

    private Long liabilityInsuranceI;

    private Long liabilityInsuranceIi;

    private Long propertyDamage;

    private Long personalInjury;

    private Long uninsuredVehicleDamage;

    private Long ownVehicleDamage;

    private Long specialItems;

    private String remarks;
}
