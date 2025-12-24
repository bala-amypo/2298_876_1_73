package com.example.demo.controller;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
public class WorkflowTemplateController {

    @Autowired
    private WorkflowTemplateService templateService;

    @PostMapping
    public ResponseEntity<WorkflowTemplate> createTemplate(@RequestBody WorkflowTemplate template) {
        return ResponseEntity.ok(templateService.createTemplate(template));
    }

    @GetMapping
    public ResponseEntity<List<WorkflowTemplate>> getAllTemplates() {
        return ResponseEntity.ok(templateService.getAllTemplates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkflowTemplate> getTemplate(@PathVariable Long id) {
        return ResponseEntity.ok(templateService.getTemplateById(id).orElseThrow());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkflowTemplate> updateTemplate(@PathVariable Long id, @RequestBody WorkflowTemplate template) {
        return ResponseEntity.ok(templateService.updateTemplate(id, template));
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<WorkflowTemplate> activateTemplate(@PathVariable Long id, @RequestParam boolean active) {
        return ResponseEntity.ok(templateService.activateTemplate(id, active));
    }
}