package com.example.demo.dto;

public class WorkflowTemplateRequest {
    private String templateName;
    private String description;
    private Integer totalLevels;
    private Boolean active;

    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Integer getTotalLevels() { return totalLevels; }
    public void setTotalLevels(Integer totalLevels) { this.totalLevels = totalLevels; }
    
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}