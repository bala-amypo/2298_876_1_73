package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "workflow_template")
public class WorkflowTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;   // 👈 FIELD NAME IS "name"

    // getters & setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
