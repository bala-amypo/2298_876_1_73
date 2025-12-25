package com.example.demo.service.impl;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("workflowStepConfigServiceImpl")
public class WorkflowStepConfigServiceImpl {
    
    @Autowired
    private WorkflowStepConfigRepository stepRepository;
    
    public WorkflowStepConfig createStep(WorkflowStepConfig step) {
        return stepRepository.save(step);
    }
    
    public List<WorkflowStepConfig> getStepsByTemplateId(Long templateId) {
        return stepRepository.findByTemplateIdOrderByLevelNumberAsc(templateId);
    }
}