package com.posco.othermanagement.s20a01.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

//<<< DDD / Value Object
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInfo {

    private String EmployeeId;

    private String Name;

    private String Company;

    private String ResponsibleSettlement;

    private String Position;

    private String ResponsibleTask;

    private String PhoneNumber;

    private String LicenseNumber;

    private String IdNumber;

    private String ResponsibleVehicleNumber;

    private String VehicleType;

    private String RetirementStatus;

    private Date RetirementDate;

    private String Photo;

    private String Remarks;
}
//>>> DDD / Value Object
