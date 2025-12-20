package com.example.demo.model;

public class ApprovalAction {

    private Long id;

    // ✅ REQUIRED for repository method
    private Integer level;

    // ✅ REQUIRED for repository method
    private String action;

    // optional but safe
    private Long approverId;

    // getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getApproverId() {
        return approverId;
    }

    public void setApproverId(Long approverId) {
        this.approverId = approverId;
    }
}
