package com.example.demo.controller;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/templates")
@Tag(name = "Workflow Templates")
public class WorkflowTemplateController {

    private final WorkflowTemplateService workflowTemplateService;

    public WorkflowTemplateController(WorkflowTemplateService workflowTemplateService) {
        this.workflowTemplateService = workflowTemplateService;
    }

    @Operation(summary = "Create workflow template")
    @PostMapping
    public WorkflowTemplate createTemplate(@RequestBody WorkflowTemplate template) {
        return workflowTemplateService.createTemplate(template);
    }

    @Operation(summary = "Get template by id")
    @GetMapping("/{id}")
    public Optional<WorkflowTemplate> getTemplate(@PathVariable Long id) {
        return workflowTemplateService.getTemplateById(id);
    }

    @Operation(summary = "Update workflow template")
    @PutMapping("/{id}")
    public WorkflowTemplate updateTemplate(
            @PathVariable Long id,
            @RequestBody WorkflowTemplate template
    ) {
        return workflowTemplateService.updateTemplate(id, template);
    }

    @Operation(summary = "Get all templates")
    @GetMapping
    public List<WorkflowTemplate> getAllTemplates() {
        return workflowTemplateService.getAllTemplates();
    }
}
