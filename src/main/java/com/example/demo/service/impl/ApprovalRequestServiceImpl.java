package com.example.demo.service.impl;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.*;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    private final ApprovalRequestRepository requestRepository;

    public ApprovalRequestServiceImpl(
            ApprovalRequestRepository requestRepository,
            WorkflowStepConfigRepository stepRepository,
            WorkflowTemplateRepository templateRepository,
            ApprovalActionRepository actionRepository
    ) {
        this.requestRepository = requestRepository;
    }

    @Override
    public ApprovalRequest createRequest(ApprovalRequest request) {
        request.setStatus("PENDING");
        return requestRepository.save(request);
    }

    @Override
    public List<ApprovalRequest> getRequestsByRequester(Long userId) {
        return requestRepository.findByRequesterId(userId);
    }

    @Override
    public List<ApprovalRequest> getAllRequests() {
        return requestRepository.findAll();
    }
}
