package com.posco.standardmanagement.s20a01.domain;

import com.posco.standardmanagement.s20a01.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "dispatchRequests",
    path = "dispatchRequests"
)
public interface DispatchRequestRepository
    extends JpaRepository<DispatchRequest, Long> {}
