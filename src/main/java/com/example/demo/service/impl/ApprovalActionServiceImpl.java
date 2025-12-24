package com.example.demo.service.impl;

import com.example.demo.model.ApprovalAction;
import com.example.demo.repository.ApprovalActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("approvalActionServiceImpl")
public class ApprovalActionServiceImpl {
    
    @Autowired
    private ApprovalActionRepository actionRepository;
    
    public ApprovalAction createAction(ApprovalAction action) {
        return actionRepository.save(action);
    }
    
    public List<ApprovalAction> getActionsByRequestId(Long requestId) {
        return actionRepository.findByRequestId(requestId);
    }
}