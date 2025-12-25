package com.example.demo.dto;

public class ApprovalRequestDto {
    private Long templateId;
    private Long requesterId;
    private String requestTitle;
    private String requestPayloadJson;
    private String status;

    public Long getTemplateId() { return templateId; }
    public void setTemplateId(Long templateId) { this.templateId = templateId; }
    
    public Long getRequesterId() { return requesterId; }
    public void setRequesterId(Long requesterId) { this.requesterId = requesterId; }
    
    public String getRequestTitle() { return requestTitle; }
    public void setRequestTitle(String requestTitle) { this.requestTitle = requestTitle; }
    
    public String getRequestPayloadJson() { return requestPayloadJson; }
    public void setRequestPayloadJson(String requestPayloadJson) { this.requestPayloadJson = requestPayloadJson; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}