package com.example.demo.dto;

public class ApprovalActionDto {
    private Long requestId;
    private Long approverId;
    private Integer levelNumber;
    private String action;
    private String comments;

    public Long getRequestId() { return requestId; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }
    
    public Long getApproverId() { return approverId; }
    public void setApproverId(Long approverId) { this.approverId = approverId; }
    
    public Integer getLevelNumber() { return levelNumber; }
    public void setLevelNumber(Integer levelNumber) { this.levelNumber = levelNumber; }
    
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
}