package com.example.demo.service.impl;

import com.example.demo.model.AuditLogRecord;
import com.example.demo.repository.AuditLogRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("auditLogServiceImpl")
public class AuditLogServiceImpl {
    
    @Autowired
    private AuditLogRecordRepository auditRepository;
    
    public AuditLogRecord createAuditLog(AuditLogRecord auditLog) {
        return auditRepository.save(auditLog);
    }
    
    public List<AuditLogRecord> getAuditLogsByRequestId(Long requestId) {
        return auditRepository.findByRequestId(requestId);
    }
}