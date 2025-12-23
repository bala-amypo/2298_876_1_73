package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class WorkflowTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String templateName;  // used in tests
    private int totalLevels;
    private String description;
    private boolean active;

    // Getters and Setters
    public Long getId() { return id; }

    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }

    public int getTotalLevels() { return totalLevels; }
    public void setTotalLevels(int totalLevels) { this.totalLevels = totalLevels; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
