package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ApprovalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long templateId;
    private Long requesterId;
    private String requestTitle;

    @Lob
    private String requestPayloadJson;

    private String status;
    private Integer currentLevel;
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        status = "PENDING";
        createdAt = LocalDateTime.now();
    }

    // getters & setters
}
