package com.example.demo.service.impl;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    @Autowired
    private ApprovalRequestRepository repository;

    @Override
    public ApprovalRequest save(ApprovalRequest request) {
        return repository.save(request);
    }

    @Override
    public List<ApprovalRequest> getAll() {
        return repository.findAll();
    }

    @Override
    public ApprovalRequest getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ApprovalRequest update(Long id, ApprovalRequest request) {
        ApprovalRequest existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTitle(request.getTitle());
            existing.setDescription(request.getDescription());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
