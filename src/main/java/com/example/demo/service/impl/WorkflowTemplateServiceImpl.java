package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service("workflowTemplateServiceImpl")
public class WorkflowTemplateServiceImpl {
    
    @Autowired
    private WorkflowTemplateRepository templateRepository;
    
    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        return templateRepository.save(template);
    }
    
    public Optional<WorkflowTemplate> getTemplateById(Long id) {
        return templateRepository.findById(id);
    }
    
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template) {
        template.setId(id);
        return templateRepository.save(template);
    }
    
    public WorkflowTemplate activateTemplate(Long id, Boolean active) {
        WorkflowTemplate template = templateRepository.findById(id).orElseThrow();
        template.setActive(active);
        return templateRepository.save(template);
    }
    
    public List<WorkflowTemplate> getAllTemplates() {
        return templateRepository.findAll();
    }
}