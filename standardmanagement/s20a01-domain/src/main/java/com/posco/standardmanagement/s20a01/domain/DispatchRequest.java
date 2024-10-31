package com.posco.standardmanagement.s20a01.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DispatchRequest_table")
@Data
public class DispatchRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dispatchRequestId;

    private String applicantId;

    private Date applicationDate;

    private String applicantDepartmentCode;

    private String officePhoneNumber;

    private String mobilePhoneNumber;

    private String approverId;

    private String approverPosition;

    private String mainDepartment;

    private String mainDepartmentManagerId;

    private Date approvalDate;

    private String progressStatus;

    private String usagePurposeCode;

    private String usagePurposeDetail;

    private String userId;

    private String visitor;

    private Long numberOfPassengers;

    private Date operationPeriodFrom;

    private Date operationPeriodTo;

    private String inOutDistinction;

    private String roundTrip;

    private String operationSection1;

    private String operationSection2;

    private String operationSection3;

    private String operationSection4;

    private String operationSection5;

    private Long requestedNumber1;

    private Long requestedNumber2;

    private Long requestedNumber3;

    private String driverIncluded;

    private String detailedSchedule;

    private String attachedDocumentName;

    private String attachedDocument;

    private String emailSent;

    private String smsSent;

    private String dispatchResultContent;

    private String dispatchCarNumber;

    private String dispatchDriverId;

    private String dispatchDriverPhoneNumber;

    private String remarks;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    private Applicant applicant;

    @Embedded
    private Approver approver;
}
