package com.example.demo.dto;

public class WorkflowStepConfigDto {
    private Long templateId;
    private Integer levelNumber;
    private String approverRole;
    private String instructions;

    public Long getTemplateId() { return templateId; }
    public void setTemplateId(Long templateId) { this.templateId = templateId; }
    
    public Integer getLevelNumber() { return levelNumber; }
    public void setLevelNumber(Integer levelNumber) { this.levelNumber = levelNumber; }
    
    public String getApproverRole() { return approverRole; }
    public void setApproverRole(String approverRole) { this.approverRole = approverRole; }
    
    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }
}