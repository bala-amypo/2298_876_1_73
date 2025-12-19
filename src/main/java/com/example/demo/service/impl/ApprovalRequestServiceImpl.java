package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.service.ApprovalRequestService;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    @Autowired
    private ApprovalRequestRepository repository;

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
                .orElseThrow(() -> new RuntimeException("Request not found"));
    }

    @Override
    public ApprovalRequest updateRequest(Long id, ApprovalRequest request) {
        ApprovalRequest existing = getRequestById(id);
        existing.setTitle(request.getTitle());
        existing.setDescription(request.getDescription());
        return repository.save(existing);
    }

    @Override
    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }
}
