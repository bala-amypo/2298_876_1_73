package com.example.demo.service.impl;

import java.time.LocalDateTime;
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
    public ApprovalRequest create(ApprovalRequest request) {
        request.setStatus("PENDING");
        request.setCreatedAt(LocalDateTime.now());
        request.setCurrentLevel(1);
        return repository.save(request);
    }

    @Override
    public List<ApprovalRequest> getAll() {
        return repository.findAll();
    }

    @Override
    public ApprovalRequest getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public ApprovalRequest update(Long id, ApprovalRequest request) {
        ApprovalRequest existing = getById(id);
        existing.setTitle(request.getTitle());
        existing.setDescription(request.getDescription());
        existing.setStatus(request.getStatus());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
