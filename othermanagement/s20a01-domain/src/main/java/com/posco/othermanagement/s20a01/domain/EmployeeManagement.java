package com.posco.othermanagement.s20a01.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "EmployeeManagement_table")
@Data
public class EmployeeManagement {

    private String company;

    private String responsibleSettlement;

    private String position;

    private String responsibleTask;

    private String phoneNumber;

    private String licenseNumber;

    private String idNumber;

    private String responsibleVehicleNumber;

    private String vehicleType;

    private String retirementStatus;

    private Date retirementDate;

    private String photo;

    private String remarks;

    @Embedded
    private EmployeeInfo employeeInfo;

    @EmbeddedId
    private EmployeeId employeeId;

    @Embedded
    private Name name;

    public void processEmployeeRetirement(
        Date retirementDate,
        String retirementStatus
    ) {
        // 비즈니스 로직 구현
    }
}
