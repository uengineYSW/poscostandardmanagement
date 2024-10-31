package com.posco.standardmanagement.s20a01.service;

import com.posco.standardmanagement.s20a01.domain.DispatchRequest;
import com.posco.standardmanagement.s20a01.domain.DispatchRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/dispatchRequests")
@Service
@Transactional
public class DispatchRequestRepositoryService {

    private final DispatchRequestRepository dispatchRequestRepository;

    @Autowired
    public DispatchRequestRepositoryService(
        DispatchRequestRepository dispatchRequestRepository
    ) {
        this.dispatchRequestRepository = dispatchRequestRepository;
    }
}
