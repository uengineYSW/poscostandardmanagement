package com.posco.standardmanagement.s20a01.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "AccidentRecord_table")
@Data
public class AccidentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;

    private Date accidentDate;

    private String accidentType;

    private String accidentPerson;

    private String confirmer;

    private String accidentDetail;

    private String remarks;
}
