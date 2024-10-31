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
public class SettlementPeriod {

    private Date SettlementPeriodFrom;

    private Date SettlementPeriodTo;
}
//>>> DDD / Value Object