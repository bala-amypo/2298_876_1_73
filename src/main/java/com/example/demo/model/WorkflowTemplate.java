package com.example.demo.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "workflow_template")
public class WorkflowTemplate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "template_name")
    private String templateName;

    @Column(length = 500)
    private String description;

    private boolean active;

    private int totalLevels;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public int getTotalLevels() { return totalLevels; }
    public void setTotalLevels(int totalLevels) { this.totalLevels = totalLevels; }
}
