package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository workflowTemplateRepository;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository workflowTemplateRepository) {
        this.workflowTemplateRepository = workflowTemplateRepository;
    }

    // ✅ get all templates
    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return workflowTemplateRepository.findAll();
    }

    // ✅ activate or deactivate template
    @Override
    public WorkflowTemplate activateTemplate(Long templateId, boolean active) {
        WorkflowTemplate template = workflowTemplateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Workflow template not found"));

        template.setActive(active);  // matches model's setActive()
        return workflowTemplateRepository.save(template);
    }

    // ✅ update template
    @Override
    public WorkflowTemplate updateTemplate(Long templateId, WorkflowTemplate updatedTemplate) {
        WorkflowTemplate existing = workflowTemplateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Workflow template not found"));

        existing.setTemplateName(updatedTemplate.getTemplateName()); // updated method name
        existing.setActive(updatedTemplate.getActive());              // updated method name
        existing.setTotalLevels(updatedTemplate.getTotalLevels());
        existing.setDescription(updatedTemplate.getDescription());

        return workflowTemplateRepository.save(existing);
    }

    // ✅ create template
    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        return workflowTemplateRepository.save(template);
    }

    // ✅ get template by ID
    @Override
    public java.util.Optional<WorkflowTemplate> getTemplateById(Long templateId) {
        return workflowTemplateRepository.findById(templateId);
    }
}
