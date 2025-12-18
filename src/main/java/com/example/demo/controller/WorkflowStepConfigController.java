package com.example.demo.controller;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
@Tag(name = "Workflow Steps")
public class WorkflowStepConfigController {

    private final WorkflowStepConfigService service;

    public WorkflowStepConfigController(WorkflowStepConfigService service) {
        this.service = service;
    }

    @PostMapping("/")
    public WorkflowStepConfig createStep(@RequestBody WorkflowStepConfig step) {
        return service.createStep(step);
    }

    @GetMapping("/template/{templateId}")
    public List<WorkflowStepConfig> getStepsByTemplate(@PathVariable Long templateId) {
        return service.getStepsForTemplate(templateId);
    }
}
