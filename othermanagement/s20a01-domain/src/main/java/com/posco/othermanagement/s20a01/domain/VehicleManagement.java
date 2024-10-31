package com.posco.othermanagement.s20a01.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "VehicleManagement_table")
@Data
public class VehicleManagement {

    private String taxType;

    private String employeeId;

    private Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq;

    private Long amount;

    private Long vat;

    private Long totalAmount;

    private String remarks;

    @Enumerated(EnumType.STRING)
    private VehicleInfo vehicleInfo;

    @Embedded
    private VehicleNumber vehicleNumber;

    @Embedded
    private VehicleType vehicleType;
}
