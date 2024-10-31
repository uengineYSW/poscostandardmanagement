package com.posco.standardmanagement.s20a01.domain;

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
public class VehicleSpec {

    private String VehicleTypeCode;

    private String VehicleModelCode;

    private String VehicleYear;

    private String Output;

    private Long Length;

    private Long Width;

    private Long Height;

    private Long Weight;

    private Long LoadCapacity;

    private Long Displacement;

    private Long SeatingCapacity;

    private Long StandardFuelEfficiency;

    private Long FuelTankCapacity;
}
//>>> DDD / Value Object
