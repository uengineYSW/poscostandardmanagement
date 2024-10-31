package com.posco.standardmanagement.s20a01.domain;

import com.posco.standardmanagement.s20a01.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "insuranceInfos",
    path = "insuranceInfos"
)
public interface InsuranceInfoRepository
    extends JpaRepository<InsuranceInfo, Long> {}
