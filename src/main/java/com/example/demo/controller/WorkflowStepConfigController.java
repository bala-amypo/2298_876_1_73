package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class WorkflowStepConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long templateId;
    private Integer levelNumber;
    private String approverRole;
    private Boolean isFinalStep;
    private String instructions;

    // getters & setters
}
