package com.posco.standardmanagement.s20a01.service;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class MarkVehicleUnavailableCommand {

    private Long vehicleId;
    private String unavailabilityReason;
    private Date unavailabilityDate;
}
