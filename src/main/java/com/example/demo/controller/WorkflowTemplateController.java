package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;

@RestController
@RequestMapping("/api/templates")
public class WorkflowTemplateController {

    private final WorkflowTemplateService service;

    public WorkflowTemplateController(WorkflowTemplateService service) {
        this.service = service;
    }

    @PostMapping
    public WorkflowTemplate create(@RequestBody WorkflowTemplate t) {
        return service.create(t);
    }

    @GetMapping("/{id}")
    public WorkflowTemplate get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<WorkflowTemplate> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public WorkflowTemplate update(@PathVariable Long id,
                                   @RequestBody WorkflowTemplate t) {
        return service.update(id, t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
