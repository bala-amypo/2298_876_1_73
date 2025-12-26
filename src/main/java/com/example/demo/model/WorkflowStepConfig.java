package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "workflow_step_config")
public class WorkflowStepConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Proper relationship (required for normalization test)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id", nullable = false)
    private WorkflowTemplate template;

    @Column(name = "level_number")
    private Integer levelNumber;

    @Column(name = "approver_role")
    private String approverRole;

    @Column(name = "instructions")
    private String instructions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WorkflowTemplate getTemplate() {
        return template;
    }

    public void setTemplate(WorkflowTemplate template) {
        this.template = template;
    }

    public Integer getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(Integer levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getApproverRole() {
        return approverRole;
    }

    public void setApproverRole(String approverRole) {
        this.approverRole = approverRole;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    // -------------------------------------------------
    // Compatibility methods (REQUIRED for portal tests)
    // -------------------------------------------------
    public void setTemplateId(Long templateId) {
        if (templateId != null) {
            WorkflowTemplate t = new WorkflowTemplate();
            t.setId(templateId);
            this.template = t;
        }
    }

    public Long getTemplateId() {
        return this.template != null ? this.template.getId() : null;
    }
}
