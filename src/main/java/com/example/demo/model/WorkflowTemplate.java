package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "workflow_template")
public class WorkflowTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "template_name", unique = true, nullable = false)
    private String templateName;

    @Column(name = "total_levels")
    private Integer totalLevels;

    @Column(name = "active")
    private Boolean active = true;

    @Column(name = "description")
    private String description;

    @OneToMany(
        mappedBy = "template",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<WorkflowStepConfig> steps;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }

    public Integer getTotalLevels() { return totalLevels; }
    public void setTotalLevels(Integer totalLevels) { this.totalLevels = totalLevels; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<WorkflowStepConfig> getSteps() { return steps; }
    public void setSteps(List<WorkflowStepConfig> steps) { this.steps = steps; }
}
