package com.example.demo.service.impl;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("approvalRequestServiceImpl")
public class ApprovalRequestServiceImpl {
    
    @Autowired
    private ApprovalRequestRepository requestRepository;
    
    public ApprovalRequest createRequest(ApprovalRequest request) {
        return requestRepository.save(request);
    }
    
    public List<ApprovalRequest> getRequestsByRequester(Long requesterId) {
        return requestRepository.findByRequesterId(requesterId);
    }
    
    public List<ApprovalRequest> getAllRequests() {
        return requestRepository.findAll();
    }
}