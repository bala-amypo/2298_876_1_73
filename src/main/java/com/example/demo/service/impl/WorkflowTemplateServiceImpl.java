package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository workflowTemplateRepository;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository workflowTemplateRepository) {
        this.workflowTemplateRepository = workflowTemplateRepository;
    }

    // ✅ FIX 1: activateTemplate
    @Override
    public WorkflowTemplate activateTemplate(Long templateId, boolean active) {

        WorkflowTemplate template = workflowTemplateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Workflow template not found"));

        template.setActive(active);
        return workflowTemplateRepository.save(template);
    }

    // ✅ FIX 2: updateTemplate (THIS WAS MISSING)
    @Override
    public WorkflowTemplate updateTemplate(Long templateId, WorkflowTemplate updatedTemplate) {

        WorkflowTemplate existing = workflowTemplateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Workflow template not found"));

        existing.setName(updatedTemplate.getName());
        existing.setActive(updatedTemplate.isActive());

        return workflowTemplateRepository.save(existing);
    }
}
