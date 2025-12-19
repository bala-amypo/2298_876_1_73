package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ApprovalRequest;

public interface ApprovalRequestService {

    ApprovalRequest createRequest(ApprovalRequest request);

    List<ApprovalRequest> getAllRequests();

    ApprovalRequest getRequestById(Long id);

    ApprovalRequest updateRequest(Long id, ApprovalRequest request);

    void deleteRequest(Long id);
}
