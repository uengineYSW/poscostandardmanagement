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
public class VehicleInfo {

    private Long VehicleNumberId;

    private Date Date;

    private Long Seq;

    private String VehicleType;

    private String Item;

    private Long UnitPrice;

    private Long Quantity;

    private Long SupplyAmount;

    private Long Vat;

    private Long Total;

    private String Remarks;
}
//>>> DDD / Value Object
