package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "workflow_template")
public class WorkflowTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;   // used by findByName()

    @Column(nullable = false)
    private boolean active = true;   // ✅ REQUIRED

    // getters & setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {   // ✅ REQUIRED
        this.active = active;
    }
}
