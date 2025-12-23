package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.stereotype.Service;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    private final WorkflowTemplateRepository workflowTemplateRepository;

    public ApprovalRequestServiceImpl(WorkflowTemplateRepository workflowTemplateRepository) {
        this.workflowTemplateRepository = workflowTemplateRepository;
    }

    @Override
    public void createRequest(String templateName) {

        // ✅ CORRECT METHOD NAME
        WorkflowTemplate template = workflowTemplateRepository
                .findByName(templateName)
                .orElseThrow(() -> new RuntimeException("Workflow template not found"));

        // continue your logic here
    }
}
