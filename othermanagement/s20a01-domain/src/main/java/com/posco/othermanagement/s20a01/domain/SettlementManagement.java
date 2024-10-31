package com.posco.othermanagement.s20a01.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SettlementManagement_table")
@Data
public class SettlementManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String settlementType;

    private Date settlementDate;

    private String confirmationStatus;

    private Date settlementPeriodFrom;

    private Date settlementPeriodTo;

    private Long vehicleCount1;

    private Long vehicleCount2;

    private Long vehicleCount3;

    private Long vehicleCount4;

    private Long vehicleCount5;

    private Long vehicleCount6;

    private Integer operatingStaff1;

    private Integer operatingStaff2;

    private Integer operatingStaff3;

    private Integer operatingStaff4;

    private Integer operatingStaff5;

    private Integer operatingStaff6;

    private Long materialCostPassenger;

    private Long materialCostBus;

    private Long fuelCostPassenger;

    private Long fuelCostBus;

    private Long partsCostPassenger;

    private Long partsCostBus;

    private Long laborCostPassenger;

    private Long laborCostBus;

    private Long directLaborCostPassenger;

    private Long directLaborCostBus;

    private Long indirectLaborCostPassenger;

    private Long indirectLaborCostBus;

    private Long expensesPassenger;

    @Embedded
    private SettlementInfo settlementInfo;

    @Embedded
    private SettlementPeriod settlementPeriod;

    @Embedded
    private Amount amount;
}
