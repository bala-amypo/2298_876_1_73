package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "workflow_template")
public class WorkflowTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tests expect this
    @Column(nullable = false, unique = true)
    private String templateName;

    // Tests expect this
    @Column(nullable = false)
    private int totalLevels;

    // Optional description field
    @Column(length = 500)
    private String description;

    // Active field
    @Column(nullable = false)
    private boolean active = true;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public int getTotalLevels() {
        return totalLevels;
    }

    public void setTotalLevels(int totalLevels) {
        this.totalLevels = totalLevels;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getActive() {  // test expects getActive(), not isActive()
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
