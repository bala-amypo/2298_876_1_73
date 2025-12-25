package com.example.demo.controller;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
public class WorkflowStepConfigController {

    @Autowired
    private WorkflowStepConfigService stepService;

    @PostMapping
    public ResponseEntity<WorkflowStepConfig> createStep(@RequestBody WorkflowStepConfig step) {
        return ResponseEntity.ok(stepService.createStep(step));
    }

    @GetMapping("/template/{templateId}")
    public ResponseEntity<List<WorkflowStepConfig>> getStepsByTemplate(@PathVariable Long templateId) {
        return ResponseEntity.ok(stepService.getStepsByTemplateId(templateId));
    }
}