package com.posco.standardmanagement.s20a01.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PreventiveInspection_table")
@Data
public class PreventiveInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;

    private String inspectionContent;

    private String regularCheckStandard;

    private Long standardKm;

    private Long recentInspectionKm;

    private Long inspectionScheduledKm;

    private Double standardReport;

    private Date recentInspectionDate;

    private Date inspectionScheduledDate;

    private String remarks;
}
