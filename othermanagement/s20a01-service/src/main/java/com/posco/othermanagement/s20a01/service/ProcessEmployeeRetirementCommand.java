package com.posco.othermanagement.s20a01.service;

import com.posco.othermanagement.s20a01.domain.EmployeeId;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ProcessEmployeeRetirementCommand {

    private EmployeeId employeeId;
    private Date retirementDate;
    private String retirementStatus;
}
