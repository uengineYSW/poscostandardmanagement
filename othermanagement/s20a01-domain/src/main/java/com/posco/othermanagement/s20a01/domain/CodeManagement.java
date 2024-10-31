package com.posco.othermanagement.s20a01.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CodeManagement_table")
@Data
public class CodeManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String codeCategoryName;

    private String settlementType;

    private String remarks;

    @Embedded
    private CodeInfo codeInfo;

    @Embedded
    private CodeCategory codeCategory;

    @Embedded
    private Code code;
}
