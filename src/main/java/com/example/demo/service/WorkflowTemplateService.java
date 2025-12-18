package com.example.demo.service;

import java.util.List;
import com.example.demo.model.WorkflowTemplate;

public interface WorkflowTemplateService {

    WorkflowTemplate create(WorkflowTemplate template);
    WorkflowTemplate getById(Long id);
    List<WorkflowTemplate> getAll();
    WorkflowTemplate update(Long id, WorkflowTemplate template);
    void delete(Long id);
}
