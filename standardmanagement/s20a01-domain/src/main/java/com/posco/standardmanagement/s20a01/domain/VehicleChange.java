package com.posco.standardmanagement.s20a01.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "VehicleChange_table")
@Data
public class VehicleChange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;

    private Date changeDate;

    private String oldVehicleNumber;

    private String changeReason;

    private String remarks;
}
