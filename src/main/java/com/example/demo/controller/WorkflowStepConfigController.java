package com.example.demo.controller;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
@Tag(name = "Workflow Steps")
public class WorkflowStepConfigController {

    private final WorkflowStepConfigService workflowStepConfigService;

    public WorkflowStepConfigController(
            WorkflowStepConfigService workflowStepConfigService
    ) {
        this.workflowStepConfigService = workflowStepConfigService;
    }

    @Operation(summary = "Create workflow step")
    @PostMapping
    public WorkflowStepConfig createStep(@RequestBody WorkflowStepConfig step) {
        return workflowStepConfigService.createStep(step);
    }

    @Operation(summary = "Get steps by template id")
    @GetMapping("/template/{templateId}")
    public List<WorkflowStepConfig> getSteps(
            @PathVariable Long templateId
    ) {
        return workflowStepConfigService.getStepsForTemplate(templateId);
    }
}
