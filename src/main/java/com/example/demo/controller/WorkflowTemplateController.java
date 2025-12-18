package com.example.demo.controller;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
@Tag(name = "Workflow Templates")
public class WorkflowTemplateController {

    private final WorkflowTemplateService service;

    public WorkflowTemplateController(WorkflowTemplateService service) {
        this.service = service;
    }

    @PostMapping("/")
    public WorkflowTemplate createTemplate(@RequestBody WorkflowTemplate template) {
        return service.createTemplate(template);
    }

    @GetMapping("/{id}")
    public WorkflowTemplate getTemplate(@PathVariable Long id) {
        return service.getTemplateById(id);
    }

    @GetMapping("/")
    public List<WorkflowTemplate> getAllTemplates() {
        return service.getAllTemplates();
    }

    @PutMapping("/{id}")
    public WorkflowTemplate updateTemplate(
            @PathVariable Long id,
            @RequestBody WorkflowTemplate template) {
        return service.updateTemplate(id, template);
    }
}
