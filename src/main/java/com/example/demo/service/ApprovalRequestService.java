package com.example.demo.service;

import com.example.demo.model.ApprovalRequest;
import java.util.List;

public interface ApprovalRequestService {

    ApprovalRequest save(ApprovalRequest request);

    List<ApprovalRequest> getAll();

    ApprovalRequest getById(Long id);

    ApprovalRequest update(Long id, ApprovalRequest request);

    void delete(Long id);
}
