package com.example.demo.dto;

public class AuditLogDto {
    private Long requestId;
    private String eventType;
    private String details;

    public Long getRequestId() { return requestId; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }
    
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}