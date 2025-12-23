package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository workflowTemplateRepository;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository workflowTemplateRepository) {
        this.workflowTemplateRepository = workflowTemplateRepository;
    }

    // ✅ Get all templates
    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return workflowTemplateRepository.findAll();
    }

    // ✅ Get template by ID (returns Optional)
    @Override
    public Optional<WorkflowTemplate> getTemplateById(Long id) {
        return workflowTemplateRepository.findById(id);
    }

    // ✅ Activate/Deactivate template
    @Override
    public WorkflowTemplate activateTemplate(Long templateId, boolean active) {
        WorkflowTemplate template = workflowTemplateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Workflow template not found"));
        template.setActive(active);
        return workflowTemplateRepository.save(template);
    }

    // ✅ Update template
    @Override
    public WorkflowTemplate updateTemplate(Long templateId, WorkflowTemplate updatedTemplate) {
        WorkflowTemplate existing = workflowTemplateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Workflow template not found"));
        existing.setName(updatedTemplate.getName());
        existing.setActive(updatedTemplate.isActive());
        return workflowTemplateRepository.save(existing);
    }

    // ✅ CREATE template (THIS WAS MISSING)
    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        return workflowTemplateRepository.save(template);
    }
}
