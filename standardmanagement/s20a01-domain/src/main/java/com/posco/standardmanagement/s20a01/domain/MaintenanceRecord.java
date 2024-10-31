package com.posco.standardmanagement.s20a01.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MaintenanceRecord_table")
@Data
public class MaintenanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;

    private Date maintenanceDate;

    private Long maintenanceSeq;

    private String maintenanceCompanyCode;

    private String maintenanceItemCode;

    private String maintenanceItemName;

    private String unit;

    private Long quantity;

    private Long unitPrice;

    private Long supplyAmount;

    private Long tax;

    private Long amount;

    private String preventiveMaintenance;

    private String preventiveMaintenanceItem;

    private String remarks;
}
