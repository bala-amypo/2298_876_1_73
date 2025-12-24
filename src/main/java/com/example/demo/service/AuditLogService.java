package com.example.demo.service;

import com.example.demo.repository.AuditLogRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditLogService {
    
    @Autowired
    private AuditLogRecordRepository auditRepository;
}