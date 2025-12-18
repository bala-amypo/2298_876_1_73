package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ApprovalRequest;

public interface ApprovalRequestService {

    ApprovalRequest create(ApprovalRequest request);
    List<ApprovalRequest> getAll();
    ApprovalRequest getById(Long id);
    ApprovalRequest update(Long id, ApprovalRequest request);
    void delete(Long id);
}
