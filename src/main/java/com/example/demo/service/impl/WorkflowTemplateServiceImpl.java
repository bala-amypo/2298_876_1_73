package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository repository;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository repository) {
        this.repository = repository;
    }

    public WorkflowTemplate create(WorkflowTemplate t) {
        return repository.save(t);
    }

    public WorkflowTemplate getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<WorkflowTemplate> getAll() {
        return repository.findAll();
    }

    public WorkflowTemplate update(Long id, WorkflowTemplate t) {
        t.setId(id);
        return repository.save(t);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
