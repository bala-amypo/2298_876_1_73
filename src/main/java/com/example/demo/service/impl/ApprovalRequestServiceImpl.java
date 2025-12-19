package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.service.ApprovalRequestService;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    private final ApprovalRequestRepository repository;

    public ApprovalRequestServiceImpl(ApprovalRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApprovalRequest createRequest(ApprovalRequest request) {
        return repository.save(request);
    }

    @Override
    public List<ApprovalRequest> getAllRequests() {
        return repository.findAll();
    }

    @Override
    public ApprovalRequest getRequestById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Approval request not found"));
    }

    @Override
    public ApprovalRequest updateRequest(Long id, ApprovalRequest request) {
        ApprovalRequest existing = getRequestById(id);
        existing.setRequestTitle(request.getRequestTitle());
        existing.setRequestPayloadJson(request.getRequestPayloadJson());
        return repository.save(existing);
    }

    @Override
    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }
}
